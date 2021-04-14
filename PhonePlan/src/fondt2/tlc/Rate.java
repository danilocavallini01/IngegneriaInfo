package fondt2.tlc;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class Rate {
	private Band[] bands;
	private int intervalInMillis;
	private String name;
	private String numberRoot;
	private double startCallCost;
	private final int ERROR = -1;

	public Band[] getBands() {
		return bands;
	}
	public String getName() {
		return name;
	}

	public boolean isApplicableTo(String destinationNumber) {
		return destinationNumber.startsWith(this.numberRoot);
	}

	public double getCallCost(PhoneCall call) {
		Band band = this.getBand(call);
		if (band == null) {
			return ERROR;
		}

		double costPerInterval = band.getCostPerInterval();

		Duration callDuration = Duration.between(call.getStart(),
				call.getEnd());
		double millisCallDuration = callDuration.toMillis();
		double callIntervals = Math
				.ceil(millisCallDuration / this.intervalInMillis);
		double cost = this.startCallCost + (costPerInterval * callIntervals);
		return cost;
	}

	private Band getBand(PhoneCall call) {
		for (Band band : bands) {
			if (band.isInBand(call.getStart())) {
				return band;
			}
		}
		return null;
	}

	public boolean isValid() {
		for (Band band : bands) {
			if (!band.isValid()) {
				return false;
			}
		}

		for (DayOfWeek day : DayOfWeek.values()) {
			Band[] bands = this.selectBandsInDay(day);

			this.sortsBandByStartTime(bands);
			System.out.println(Arrays.toString(bands));
			if (!this.validateBandsInDay(bands)) {
				return false;
			}
		}

		return true;
	}

	public Band[] selectBandsInDay(DayOfWeek day) {
		int index = 0;

		for (Band band : bands) {
			if (this.isInDayOfWeek(day, band)) {
				index++;
			}
		}

		Band[] selectedBands = new Band[index];
		index = 0;

		for (Band band : bands) {
			if (this.isInDayOfWeek(day, band)) {
				selectedBands[index++] = band;
			}
		}

		return selectedBands;
	}

	private boolean isInDayOfWeek(DayOfWeek day, Band band) {
		for (DayOfWeek selectedDayOfWeek : band.getCombinedDays()) {
			if (selectedDayOfWeek.equals(day)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateBandsInDay(Band[] bands) {
		if (!bands[0].getStartTime().equals(LocalTime.MIN)) {
			return false;
		}

		int i = 0;
		for (; i < bands.length - 1; i++) {

			if (bands[i] != null && bands[i + 1] != null) {
				if (!bands[i].getEndTime().plusNanos(1)
						.equals(bands[i + 1].getStartTime())) {
					return false;
				}
			}
		}
		if (!bands[i].getEndTime().equals(LocalTime.MAX)) {
			return false;
		}
		return true;
	}

	public void sortsBandByStartTime(Band[] bands) {
		Arrays.sort(bands, new Comparator<Band>() {
			@Override
			public int compare(Band first, Band second) {
				if (first.getStartTime().isBefore(second.getStartTime())) {
					return -1;
				} else if (first.getStartTime()
						.isAfter(second.getStartTime())) {
					return 1;
				}
				return 0;
			}
		});
	}

	public Rate(String name, Band[] bands, int intervalInMillis,
			double startCallCost, String numberRoot) {
		super();
		this.bands = bands;
		this.intervalInMillis = intervalInMillis;
		this.name = name;
		this.numberRoot = numberRoot;
		this.startCallCost = startCallCost;
	}

}
