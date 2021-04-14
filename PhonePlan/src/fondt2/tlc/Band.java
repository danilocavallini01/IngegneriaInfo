package fondt2.tlc;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import fondt2.tlc.util.DayOfWeekHelper;

public class Band {
	private DayOfWeek[] combinedDays;
	private double costPerInterval;
	private LocalTime startTime;
	private LocalTime endTime;

	public Band(LocalTime startTime, LocalTime endTime,
			DayOfWeek[] combinedDays, double costPerInterval) {
		super();
		this.combinedDays = Arrays.copyOf(combinedDays, combinedDays.length);
		this.costPerInterval = costPerInterval;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public DayOfWeek[] getCombinedDays() {
		return combinedDays;
	}
	public double getCostPerInterval() {
		return costPerInterval;
	}

	public LocalTime getStartTime() {
		return startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}

	public boolean isInBand(LocalDateTime dateTime) {
		LocalTime time = dateTime.toLocalTime();
		if (!DayOfWeekHelper.isDayIn(dateTime.getDayOfWeek(),
				this.getCombinedDays())) {
			return false;
		}
		return time.isAfter(getStartTime()) && time.isBefore(getEndTime());
	}

	public boolean isValid() {
		if (getStartTime().isAfter(getEndTime())) {
			return false;
		}
		if (getCombinedDays() == null || getCombinedDays().length == 0) {
			return false;
		}
		for (DayOfWeek dayOfWeek : combinedDays) {
			if (dayOfWeek == null) {
				return false;
			}
		}
		return getCostPerInterval() >= 0.0d;
	}

	@Override
	public String toString() {
		return "Band ["
				+ (combinedDays != null
						? "combinedDays=" + Arrays.toString(combinedDays) + ", "
						: "")
				+ (startTime != null ? "startTime=" + startTime + ", " : "")
				+ (endTime != null ? "endTime=" + endTime : "") + "]";
	}

}
