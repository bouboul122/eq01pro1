package model;



public class ShapeEMRFactory {
	
	enum eshape {
		sourcePower,
		accumulationPower,
		controlStrategy,
		conversionMonoPower,
		conversionMultiPower,
		couplingMonoPower,
		couplingMultiPower,
		accumulationInversion,
		amplificationGreaterInversion,
		amplificationLowerInversion,
		conversionControlInversion,
		couplingControlInversion,
		amplificationGreaterPower,
		amplificationLowerPower,
		sourceEstimation,
		accumulationEstimation,
		conversionMonoEstimation,
		conversionMultiEstimation,
		couplingMultiEstimation,
		couplingMonoEstimation,
		amplifactionGreaterEstimation,
		amplificationLowerEstimation		
	};
	
	public ShapeEMR getShape(eshape element, double xCoord, double yCoord, String mainColor, String borderColor)
	{
		ShapeEMR shape;
		switch(element) {
		case sourcePower:
			shape = new Source(xCoord, yCoord, mainColor, borderColor);
			break;
		case accumulationPower:
			shape = new AccumulationPowerElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case controlStrategy:
			shape = new ControlStrategyElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case conversionMonoPower:
			shape = new ConversionPowerMonoElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case conversionMultiPower:
			shape = new ConversionPowerMultiElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case couplingMonoPower:
			shape = new CouplingPowerMonoElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case couplingMultiPower:
			shape = new CouplingPowerMultiElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case accumulationInversion:
			shape = new InversionAccumulationControlElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case amplificationGreaterInversion:
			shape = new InversionAmplificationControlElementGreater(xCoord, yCoord, mainColor, borderColor);
			break;
			
		}
		return shape;
	}

}
