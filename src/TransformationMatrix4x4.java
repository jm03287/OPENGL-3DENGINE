public class TransformationMatrix4x4 {
	
	private final double ENTRY0_0;
	private final double ENTRY0_1;
	private final double ENTRY0_2;
	private final double ENTRY0_3;
	private final double ENTRY1_0;
	private final double ENTRY1_1;
	private final double ENTRY1_2;
	private final double ENTRY1_3;
	private final double ENTRY2_0;
	private final double ENTRY2_1;
	private final double ENTRY2_2;
	private final double ENTRY2_3;
	private final double ENTRY3_0;
	private final double ENTRY3_1;
	private final double ENTRY3_2;
	private final double ENTRY3_3;
	
	public TransformationMatrix4x4(double[][] entries) { //Adam constructor
		this.ENTRY0_0 = entries[0][0];
		this.ENTRY0_1 = entries[0][1];
		this.ENTRY0_2 = entries[0][2];
		this.ENTRY0_3 = entries[0][3];
		this.ENTRY1_0 = entries[1][0];
		this.ENTRY1_1 = entries[1][1];
		this.ENTRY1_2 = entries[1][2];
		this.ENTRY1_3 = entries[1][3];
		this.ENTRY2_0 = entries[2][0];
		this.ENTRY2_1 = entries[2][1];
		this.ENTRY2_2 = entries[2][2];
		this.ENTRY2_3 = entries[2][3];
		this.ENTRY3_0 = entries[3][0];
		this.ENTRY3_1 = entries[3][1];
		this.ENTRY3_2 = entries[3][2];
		this.ENTRY3_3 = entries[3][3];
	}
	
	public static TransformationMatrix4x4 transformMatrix4x4(TransformationMatrix4x4 transformationMatrix4x4, TransformationMatrix4x4 inputSeedMatrix4x4) {
		double[][] resultantMatrix = {{inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY0_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY0_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY0_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY0_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY0_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY0_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY0_3()},
									 {inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY1_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY1_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY1_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY1_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY1_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY1_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY1_3()},
									 {inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY2_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY2_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY2_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY2_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY2_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY2_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY2_3()},
									 {inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_0()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_0()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_0()*transformationMatrix4x4.getENTRY3_3(),
									 inputSeedMatrix4x4.getENTRY0_1()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_1()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_1()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_1()*transformationMatrix4x4.getENTRY3_3(),
									 inputSeedMatrix4x4.getENTRY0_2()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_2()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_2()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_2()*transformationMatrix4x4.getENTRY3_3(),
									 inputSeedMatrix4x4.getENTRY0_3()*transformationMatrix4x4.getENTRY3_0() + inputSeedMatrix4x4.getENTRY1_3()*transformationMatrix4x4.getENTRY3_1() + inputSeedMatrix4x4.getENTRY2_3()*transformationMatrix4x4.getENTRY3_2() + inputSeedMatrix4x4.getENTRY3_3()*transformationMatrix4x4.getENTRY3_3()}};
		return new TransformationMatrix4x4(resultantMatrix);
	}
	
	/*public static hVector3D transformHVector3D(TransformationMatrix4x4 transformationMatrix4x4, hVector3D inputSeedHVector3D) {
		double[] hVector3DAtt = {inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY0_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY0_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY0_2() + hVector3D.HWCOORD*transformationMatrix4x4.getENTRY0_3(),
		inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY1_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY1_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY1_2() + hVector3D.HWCOORD*transformationMatrix4x4.getENTRY1_3(),
		inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY2_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY2_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY2_2() + hVector3D.HWCOORD*transformationMatrix4x4.getENTRY2_3(),
		inputSeedHVector3D.getXCOORD()*transformationMatrix4x4.getENTRY3_0() + inputSeedHVector3D.getYCOORD()*transformationMatrix4x4.getENTRY3_1() + inputSeedHVector3D.getZCOORD()*transformationMatrix4x4.getENTRY3_2() + hVector3D.HWCOORD*transformationMatrix4x4.getENTRY3_3()};
		return new hVector3D(hVector3DAtt);
	}*/
	public static TransformationMatrix4x4 transposeMatrix4x4(TransformationMatrix4x4 transformationMatrix4x4) {
		double[][] transposeMatrix4DArr = {{transformationMatrix4x4.getENTRY0_0(), transformationMatrix4x4.getENTRY1_0(), transformationMatrix4x4.getENTRY2_0(), transformationMatrix4x4.getENTRY3_0()},
		{transformationMatrix4x4.getENTRY0_1(), transformationMatrix4x4.getENTRY1_1(), transformationMatrix4x4.getENTRY2_1(), transformationMatrix4x4.getENTRY3_1()},
		{transformationMatrix4x4.getENTRY0_2(), transformationMatrix4x4.getENTRY1_2(), transformationMatrix4x4.getENTRY2_2(), transformationMatrix4x4.getENTRY3_2()},
		{transformationMatrix4x4.getENTRY0_3(), transformationMatrix4x4.getENTRY1_3(), transformationMatrix4x4.getENTRY2_3(), transformationMatrix4x4.getENTRY3_3()}};
		return new TransformationMatrix4x4(transposeMatrix4DArr);
	}//MANIFESTATION OF THE ROW SPACE
	
	
	//Transform orthogonal matrix about camera space via inverse is the adjoint transpose of the transform matrix
	public TransformationMatrix4x4 orthogonalTransformAboutADJOINTCAMERAANGLE() {
		return TransformationMatrix4x4.transposeMatrix4x4(this);
		//To be overriden only by the subclass translationTransformationMatrix4x4
		//To be implemented only by the subclasses rotationXTRANSFORMAITONMATRIX4X4, rotationYTRANSFORMAITONMATRIX4X4, rotationZTRANSFORMAITONMATRIX4X4 as extensions
	}
	
	public TransformationMatrix4x4 RotationXHTransform(double angle) {
		/*this.THETAXPITCHCOS = -Math.cos(angle*Math.PI/180);
		this.THETAXPITCHSIN =-Math.sin(angle*Math.PI/180);
		double[][] xPitchHMatrix =-{{},
				{},
				{},
				{}};
		-+super(xPitchHMatrix);*/
		// TODO Auto-generated constructor stub
		//using a look-at matrix for camera transforms is generally compuationally faster!
		return new TransformationMatrix4x4(new double[][]{{1, 0, 0, 0},
			{0, Math.cos(angle*Math.PI/180), -Math.sin(angle*Math.PI/180), 0},
			{0, Math.sin(angle*Math.PI/180), Math.cos(angle*Math.PI/180), 0},
			{0, 0, 0, 1}});
	}
	
	public static TransformationMatrix4x4 rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(TransformationMatrix4x4 transformationMatrix4x4, TransformationMatrix4x4 inputSeedMatrix4x4) {
		return TransformationMatrix4x4.transformMatrix4x4(transformationMatrix4x4.orthogonalTransformAboutADJOINTCAMERAANGLE(), inputSeedMatrix4x4                                  );
	}//The transpose of an orthogonal orthonormal rotation transform matrix is its corresponding inverse,
	//so to rotate from the camera space via the inverse transformation, simply transpose the world model space rotation transformation matrix.
	
	public TransformationMatrix4x4 RotationYHTransform(double angle) {
		/*this.PHIYYAWCOS = Math.cos(angle*Math.PI/180);
		this.PHIYYAWSIN = Math.sin(angle*Math.PI/180);
		double[][] yYawHMatrix = {{},
				{},
				{},
				{}};*/
		// TODO Auto-generated constructor stub
		return new TransformationMatrix4x4(new double[][]{{Math.cos(angle*Math.PI/180), 0, Math.sin(angle*Math.PI/180), 0},
			{0, 1, 0, 0},
			{-Math.sin(angle*Math.PI/180), 0, Math.cos(angle*Math.PI/180), 0},
			{0, 0, 0, 1}});
	}
	
	/*public static TransformationMatrix4x4 rotYHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationXHTransform transformationMatrix4x4, TransformationMatrix4x4 inputSeedMatrix4x4) {
		return TransformationMatrix4x4.transformMatrix4x4(transformationMatrix4x4.orthogonalTransformAboutADJOINTCAMERAANGLE(), inputSeedMatrix4x4                                  );
	}*/
	
	public TransformationMatrix4x4 RotationZHTransform(double angle) {
		/*this.PSIZROLLCOS = Math.cos(angle*Math.PI/180);
		this.PSIZROLLSIN = Math.sin(angle*Math.PI/180);
		double[][] zRollHMatrix = {{},
				{},
				{},
				{}};*/
		return new TransformationMatrix4x4(new double[][]{{Math.cos(angle*Math.PI/180), -Math.sin(angle*Math.PI/180), 0, 0},
			{Math.sin(angle*Math.PI/180), Math.cos(angle*Math.PI/180), 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}});
		// TODO Auto-generated constructor stub
	}
	
	/*public static TransformationMatrix4x4 rotZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationXHTransform transformationMatrix4x4, TransformationMatrix4x4 inputSeedMatrix4x4) {
		return TransformationMatrix4x4.transformMatrix4x4(transformationMatrix4x4.orthogonalTransformAboutADJOINTCAMERAANGLE(), inputSeedMatrix4x4                                  );
	}*/
	
	public TransformationMatrix4x4 rotateToWorldViewCoords(double THETAXPITCH, double PHIYYAW, double PSIZROLL) {
		return rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationZHTransform(THETAXPITCH), rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationYHTransform(PHIYYAW), rotXYZHTransformABOUTADJOINTCAMERAANGLEMATRIX(RotationXHTransform(PSIZROLL), this)));
	}
	
	public TransformationMatrix4x4 rotateModelViewCoords(double THETAXPITCH, double PHIYYAW, double PSIZROLL) {
		return this.rotateToWorldViewCoords(-PSIZROLL, -PHIYYAW, -THETAXPITCH);
	}
	
	public TransformationMatrix4x4 transformMatrix4x4(TransformationMatrix4x4 transformationMatrix4x4) {
		return transformMatrix4x4(this, transformationMatrix4x4);
	}
	
	public TransformationMatrix4x4 translateCoords(double X, double Y, double Z) {
		TransformationMatrix4x4 translationXYZ = new TransformationMatrix4x4(new double[][]{{1, 0, 0, X},
			{0, 1, 0, Y},
			{0, 0, 1, Z},
			{0, 0, 0, 1}});
		 return translationXYZ.transformMatrix4x4(this);
	}
	
	public TransformationMatrix4x4 translateToWorldViewCoords(double X, double Y, double Z) {
		return this.translateCoords(-X, -Y, -Z);
	}
	
	public TransformationMatrix4x4 scaleCoords(double X, double Y, double Z) {
		TransformationMatrix4x4 scaleXYZ = new TransformationMatrix4x4(new double[][]{{X, 0, 0, 0},
			{0, Y, 0, 0},
			{0, 0, Z, 0},
			{0, 0, 0, 1}});
		 return scaleXYZ.transformMatrix4x4(this);
	}
	
	public TransformationMatrix4x4 modelViewCoordsMatrixs4x4(double X, double Y, double Z, double THETAXPITCH, double PHIYYAW, double PSIZROLL) {
		return this.translateToWorldViewCoords(X, Y, Z).rotateToWorldViewCoords(THETAXPITCH, PHIYYAW, PSIZROLL);
	}
	

	public static TransformationMatrix4x4 projectionMatrix4x4(double topToBottomFOV, double aspectRatio, double ZNEAR, double ZFAR) {
		double invFrustum = 1/(Math.tan(topToBottomFOV*0.5*Math.PI/180));
		double depthCoefficient = 1/(ZNEAR-ZFAR);
		return new TransformationMatrix4x4(new double[][]{{invFrustum/aspectRatio, 0, 0, 0},
			{0, invFrustum, 0, 0},
			{0, 0, (ZNEAR+ZFAR)*depthCoefficient, 2*ZNEAR*ZFAR*depthCoefficient},
			{0, 0, -1, 0}});
	}
	
	public static float[] mat4GLSL(TransformationMatrix4x4 transformationMatrix4x4) {
		return new float[] {(float) transformationMatrix4x4.getENTRY0_0(), (float) transformationMatrix4x4.getENTRY1_0(), (float) transformationMatrix4x4.getENTRY2_0(), (float) transformationMatrix4x4.getENTRY3_0(),
				(float) transformationMatrix4x4.getENTRY0_1(), (float) transformationMatrix4x4.getENTRY1_1(), (float) transformationMatrix4x4.getENTRY2_1(), (float) transformationMatrix4x4.getENTRY3_1(),
				(float) transformationMatrix4x4.getENTRY0_2(), (float) transformationMatrix4x4.getENTRY1_2(), (float) transformationMatrix4x4.getENTRY2_2(), (float) transformationMatrix4x4.getENTRY3_2(),
				(float) transformationMatrix4x4.getENTRY0_3(), (float) transformationMatrix4x4.getENTRY1_3(), (float) transformationMatrix4x4.getENTRY2_3(), (float) transformationMatrix4x4.getENTRY3_3()};
	}
	
	public TransformationMatrix4x4() { //NULL constructor for identity Matrix
		this.ENTRY0_0 = 1.0;
		this.ENTRY0_1 = 0.0;
		this.ENTRY0_2 = 0.0;
		this.ENTRY0_3 = 0.0;
		this.ENTRY1_0 = 0.0;
		this.ENTRY1_1 = 1.0;
		this.ENTRY1_2 = 0.0;
		this.ENTRY1_3 = 0.0;
		this.ENTRY2_0 = 0.0;
		this.ENTRY2_1 = 0.0;
		this.ENTRY2_2 = 1.0;
		this.ENTRY2_3 = 0.0;
		this.ENTRY3_0 = 0.0;
		this.ENTRY3_1 = 0.0;
		this.ENTRY3_2 = 0.0;
		this.ENTRY3_3 = 1.0;
	}
	
	//TRANSPOSED INVERSE/ INVERTED TRANSPOSE

	public double getENTRY0_0() {
		return ENTRY0_0; 
	}

	public double getENTRY0_1() {
		return ENTRY0_1;
	}

	public double getENTRY0_2() {
		return ENTRY0_2;
	}

	public double getENTRY0_3() {
		return ENTRY0_3;
	}

	public double getENTRY1_0() {
		return ENTRY1_0;
	}

	public double getENTRY1_1() {
		return ENTRY1_1;
	}

	public double getENTRY1_2() {
		return ENTRY1_2;
	}

	public double getENTRY1_3() {
		return ENTRY1_3;
	}

	public double getENTRY2_0() {
		return ENTRY2_0;
	}

	public double getENTRY2_1() {
		return ENTRY2_1;
	}

	public double getENTRY2_2() {
		return ENTRY2_2;
	}

	public double getENTRY2_3() {
		return ENTRY2_3;
	}

	public double getENTRY3_0() {
		return ENTRY3_0;
	}

	public double getENTRY3_1() {
		return ENTRY3_1;
	}

	public double getENTRY3_2() {
		return ENTRY3_2;
	}

	public double getENTRY3_3() {
		return ENTRY3_3;
	}

	
}
