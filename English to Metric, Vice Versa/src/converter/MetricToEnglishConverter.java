package converter;

public class MetricToEnglishConverter implements ScaleConverter {

	@Override
	public double convertTemperature(double tempIn) {
		double tempInFahrenheit = (tempIn - 32) * 5/9;
		
		return tempInFahrenheit;
	}

	@Override
	public double convertDistance(double distanceIn) {
		double distanceInMiles = distanceIn / 1.609;
		
		return distanceInMiles;
	}

	@Override
	public double convertWeight(double weightIn) {
		double weightInPounds = weightIn * 2.2;
		
		return weightInPounds;
	}


}
