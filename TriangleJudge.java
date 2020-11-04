package com.javaoop.xsb;


public class TriangleJudge {
	
	public int[] sideLengh = new int[3];
	
	
	public int[] getSideLengh() {
		return sideLengh;
	}

	public void setSideLengh(int[] sideLengh) {
		this.sideLengh = sideLengh;
	}
	

	
	
	
	
	
	public TriangleJudge() {
		super();
	}

	public TriangleJudge(int[] sideLengh) {
		super();
		this.sideLengh = sideLengh;
	}

	public boolean isTriangle() {
		//判断能否构成三角形
		if (sideLengh[0] + sideLengh[1] > sideLengh[2] &&
			sideLengh[0] + sideLengh[2] > sideLengh[1] &&
			sideLengh[1] + sideLengh[2] > sideLengh[0]) {
			
			return true;
			
		}else {
			return false;
		}
	}
	
	public String shape() {
		if (Math.pow(sideLengh[0],2) + Math.pow(sideLengh[1],2) == Math.pow(sideLengh[2],2) ||
			Math.pow(sideLengh[0],2) + Math.pow(sideLengh[2],2) == Math.pow(sideLengh[1],2) ||
			Math.pow(sideLengh[1],2) + Math.pow(sideLengh[2],2) == Math.pow(sideLengh[0],2)) {
			return "直角三角形";
		}else if(Math.pow(sideLengh[0],2) + Math.pow(sideLengh[1],2) < Math.pow(sideLengh[2],2) ||
				Math.pow(sideLengh[0],2) + Math.pow(sideLengh[2],2) < Math.pow(sideLengh[1],2) ||
				Math.pow(sideLengh[1],2) + Math.pow(sideLengh[2],2) < Math.pow(sideLengh[0],2)){
			return "钝角三角形";
			
		}else {
			return "锐角三角形";
		}
	}
		
	
}
