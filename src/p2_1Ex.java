import java.nio.*;
import javax.swing.*;
import static com.jogamp.opengl.GL4.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.glu.GLU;//checkOpenGLError; printShaderLog; printProgramLog;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import com.jogamp.opengl.util.*;
// TODO import TransformationMatrix4x4;


public class p2_1Ex extends JFrame implements GLEventListener{
	private static final long serialVersionUID = 1L;
	private GLCanvas myCanvas;
	private int rendering_program;
	private int vao[] = new int[1]; //vertex array object; corresponds to model attribution for implementation as a uniform.
	private int vbo[] = new int[2]; //vertex buffer object
	//the model-view matrix can be expressed as a universal uniform shader variable amongst model-world-view
	//whereas such the projection matrix expresses a uniform shader algorithm of view-to-camera
	private float cameraX, cameraY, cameraZ;
	private float cubeLocX, cubeLocY, cubeLocZ;
	private TransformationMatrix4x4 pMat;
	
	public p2_1Ex() {
		setTitle("p2_1Ex");
		setSize(600, 400);
		setLocation(200, 200);
		myCanvas = new GLCanvas();
		myCanvas.addGLEventListener(this);
		this.add(myCanvas);
		setVisible(true);
		//FPSAnimator animtr = new FPSAnimator(myCanvas, 50); //The second arg is the FPS HZ.
		//animtr.start();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		gl.glClear(GL_DEPTH_BUFFER_BIT);
		gl.glUseProgram(rendering_program);
		
		TransformationMatrix4x4 vMat = new TransformationMatrix4x4();
		vMat.translateToWorldViewCoords(cameraX, cameraY, cameraZ);
		
		TransformationMatrix4x4 mMat = new TransformationMatrix4x4();
		mMat.translateCoords(cubeLocX, cubeLocY, cubeLocZ);
		
		TransformationMatrix4x4 mvMat = vMat.transformMatrix4x4(mMat);
		
		//embed java float array matrices as the two uniform variables
		int mv_loc = gl.glGetUniformLocation(rendering_program, "mv_matrix"); //obtain pointer to modelview matrix uniform shader's reference
		int proj_loc = gl.glGetUniformLocation(rendering_program, "proj_matrix"); //obtain pointer to projection matrix uniform shader's reference
		
		//transfer uniform variables to corresponding shader reference to be used with vertex attributes from each vertex buffer, convert to mat4 format
		gl.glUniformMatrix4fv(proj_loc, 1, false, TransformationMatrix4x4.mat4GLSL(pMat), 0);
		gl.glUniformMatrix4fv(mv_loc, 1, false, TransformationMatrix4x4.mat4GLSL(mvMat), 0);
		
		//activate and link vertex buffer object with shader's vertex attributes using VBO reference
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[0]);
		gl.glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		gl.glEnableVertexAttribArray(0);
		
		//OpenGL preset adjustments
		gl.glEnable(GL_DEPTH_TEST);
		gl.glDepthFunc(GL_LEQUAL);
		gl.glDrawArrays(GL_TRIANGLES, 0, 36);

		/*gl.glPointSize(40.0f);
		gl.glDrawArrays(GL_TRIANGLES, 0, 3);
		float bkg[] = {0.0f, 0.0f, 0.0f, 1.0f}; //clear background after every frame
		FloatBuffer bkgBuffer = Buffers.newDirectFloatBuffer(bkg);
		gl.glClearBufferfv(GL_COLOR, 0, bkgBuffer);
		/*x += inc;
		if(x > 1.0f) {
			inc = -0.01f;
		}
		if(x < -1.0f) {
			inc = 0.01f;
		}
		int offset_loc = gl.glGetUniformLocation(rendering_program, "offset");
		gl.glProgramUniform1f(rendering_program, offset_loc, x);
		gl.glDrawArrays(GL_TRIANGLES, 0, 3);*/
	}
	
	public static void main(String[] args) {
		new p2_1Ex();
	}

	
	
	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		rendering_program = createShaderProgram();
		//gl.glGenVertexArrays(vao.length, vao, 0);
		//gl.glBindVertexArray(vao[0]);
		setupVertices();
		cameraX = 0.0f; cameraY = 0.0f; cameraZ = 8.0f;
		cubeLocX = 0.0f; cubeLocY = -2.0f; cubeLocZ = 0.0f;
		
		double aspect = (double) myCanvas.getWidth() / (double) myCanvas.getHeight();
		//float aspect = (float) myCanvas.getWidth() / (float) myCanvas.getHeight();
		pMat = TransformationMatrix4x4.projectionMatrix4x4(60.0, aspect, 0.1, 1000.0); //set up view projection matrix
		//TransformationMatrix4x4.mat4GLSL();
		
	}

	private int createShaderProgram() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		/*String vshaderSource[] = {
				"#version 460 \n",
				"void main(void) \n",
				"{gl_Position = vec4(0.0, 0.0, 0.0, 1.0);} \n"
		};
		
		String fshaderSource[] = {
				"#version 460 \n",
				"out vec4 color; \n",
				"void main(void) \n",
				"{color = vec4(0.0, 0.0, 1.0, 1.0);} \n"
		};*/
		
		int vShader = gl.glCreateShader(GL_VERTEX_SHADER);
		//gl.glShaderSource(vShader, 3, vshaderSource, null, 0);
		//gl.glCompileShader(vShader);
		
		int fShader = gl.glCreateShader(GL_FRAGMENT_SHADER);
		//gl.glShaderSource(fShader, 4, fshaderSource, null, 0);
		//gl.glCompileShader(fShader);
		
		//int vfprogram = gl.glCreateProgram();
		/*gl.glAttachShader(vfprogram, vShader);
		gl.glAttachShader(vfprogram, fShader);
		gl.glLinkProgram(vfprogram);
		
		gl.glDeleteShader(vShader);
		gl.glDeleteShader(fShader);*/
		
		String vshaderSource[] = readShaderSource("C:\\Users\\jmea4\\eclipse-workspace\\OPENGL-3DENGINE\\vert.shader");
		String fshaderSource[] = readShaderSource("C:\\Users\\jmea4\\eclipse-workspace\\OPENGL-3DENGINE\\frag.shader");
		gl.glShaderSource(vShader, vshaderSource.length, vshaderSource, null, 0);
		gl.glShaderSource(fShader, fshaderSource.length, fshaderSource, null, 0);
		gl.glCompileShader(vShader);
		gl.glCompileShader(fShader);
		int vfprogram = gl.glCreateProgram();
		gl.glAttachShader(vfprogram, vShader);
		gl.glAttachShader(vfprogram, fShader);
		gl.glLinkProgram(vfprogram);
		
		gl.glDeleteShader(vShader);
		gl.glDeleteShader(fShader);
		
		return vfprogram;
		//inputSeedMatrix4x4.getENTRY0_0()*transformationMatrix4x4.ENTRY0_0
	}
	
	private void setupVertices() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		
		float[] vertex_positions = {-1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f,
				1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f,
				1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f,  1.0f, 1.0f, 1.0f, -1.0f,
				-1.0f, 1.0f, -1.0f, 1.0f, 1.0f,  1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f,
				-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f,
				-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
				1.0f, -1.0f, 1.0f,  1.0f, -1.0f, 1.0f, -1.0f};
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
		gl.glGenBuffers(vbo.length, vbo, 0);
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[0]);
		FloatBuffer vertBuf = Buffers.newDirectFloatBuffer(vertex_positions);
		gl.glBufferData(GL_ARRAY_BUFFER, vertBuf.limit()*4, vertBuf, GL_STATIC_DRAW);
	}
	
	private String[] readShaderSource(String filename) {
		Vector<String> lines = new Vector<String>();
		Scanner sc;
		try {
			sc = new Scanner(new File(filename));
		}catch(IOException e) {
			System.err.println("IOException reading file: " + e);
			return null;
		}
		while(sc.hasNext()) {
			lines.addElement(sc.nextLine());
		}
		String[] program = new String[lines.size()];
		for(int i = 0; i < lines.size(); i++) {
			program[i] = (String) lines.elementAt(i) + "\n";
		}
		return program;
	}
	
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	//*Debug Runtime and Errors Log for OpenGL and GLSL
	private void printShaderLog(int shader) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		int[] len = new int[1];
		int[] chWrittn = new int[1];
		byte[] log = null;
		
		//determine the length of the shader compilation log
		gl.glGetShaderiv(shader, GL_INFO_LOG_LENGTH, len, 0);
		if(len[0] > 0) {
			log = new byte[len[0]];
			gl.glGetShaderInfoLog(shader, len[0], chWrittn, 0, log, 0);
			System.out.println("Shader Info Log: ");
			for(int i = 0; i < log.length; i++) {
				System.out.print((char) log[i]);
			}
		}
	}
	
	void printProgramLog(int prog) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		int[] len = new int[1];
		int[] chWrittn = new int[1];
		byte[] log = null;
		
		//determine the length of the program linking log
		gl.glGetProgramiv(prog, GL_INFO_LOG_LENGTH, len, 0);
		System.out.println("Program Info Log: ");
		for(int i = 0; i < log.length; i++) {
			System.out.print((char) log[i]);
		}
	}
	
	boolean checkOpenGLError() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		boolean foundError = false;
		GLU glu = new GLU();
		int glErr = gl.glGetError();
		while(glErr != GL_NO_ERROR) {
			System.err.println("glError: " + glu.gluErrorString(glErr));
			foundError = true;
			glErr = gl.glGetError();
		}
		return foundError;
	}

}
