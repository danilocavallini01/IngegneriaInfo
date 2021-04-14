package fondt2.tlc;

public class PhonePlan {
	private String name;
	private Rate[] rates;
	private final int ERROR = -1;

	public PhonePlan(String name, Rate[] rates) {
		super();
		this.name = name;
		this.rates = rates;
	}

	public double getCallCost(PhoneCall call) {
		for (Rate checkRate : rates) {
			if (checkRate.isApplicableTo(call.getDestNumber())) {
				return checkRate.getCallCost(call);
			}
		}
		return ERROR;
	}

	public boolean isValid() {
		for (Rate checkRate : rates) {
			if (!checkRate.isValid()) {
				return false;
			}
		}

		return true;
	}

	public String getName() {
		return name;
	}

}
