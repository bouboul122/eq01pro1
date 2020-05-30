package model;



public class ShapeEMRFactory {
	
	public enum eshape {
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
		amplificationGreaterEstimation,
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
		case amplificationLowerInversion:
			shape = new InversionAmplificationControlElementLower(xCoord, yCoord, mainColor, borderColor);
			break;
		case conversionControlInversion:
			shape = new InversionConversionControlElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case couplingControlInversion:
			shape = new InversionCouplingControlElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case amplificationGreaterPower:
			shape = new PowerAmplificationGreaterElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case amplificationLowerPower:
			shape = new PowerAmplificationLowerElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case sourceEstimation:
			shape = new Source(xCoord, yCoord, mainColor, borderColor);
			break;
		case accumulationEstimation:
			shape = new AccumulationPowerElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case conversionMonoEstimation:
			shape = new ConversionPowerMonoElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case conversionMultiEstimation:
			shape = new ConversionPowerMultiElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case couplingMonoEstimation:
			shape = new CouplingPowerMonoElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case couplingMultiEstimation:
			shape = new CouplingPowerMultiElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case amplificationGreaterEstimation:
			shape = new PowerAmplificationGreaterElement(xCoord, yCoord, mainColor, borderColor);
			break;
		case amplificationLowerEstimation:
			shape = new PowerAmplificationLowerElement(xCoord, yCoord, mainColor, borderColor);
			break;
		default:
			shape = null;
		}
		return shape;
	}

}
