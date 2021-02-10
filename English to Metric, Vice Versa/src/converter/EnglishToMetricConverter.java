package converter;

public class EnglishToMetricConverter implements ScaleConverter {

	@Override
	public double convertTemperature(double tempIn) {
		double tempInCelsius = (tempIn - 32) * 5/9;
		
		return tempInCelsius;
	}

	@Override
	public double convertDistance(double distanceIn) {
		double distanceInKM = distanceIn * 1.609;
		
		return distanceInKM;
	}

	@Override
	public double convertWeight(double weightIn) {
		double weightInKG = weightIn/2.2;
		
		return weightInKG;
	}
}
