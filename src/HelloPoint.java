import static com.jogamp.opengl.GL.GL_NO_ERROR;
import static com.jogamp.opengl.GL2ES2.GL_INFO_LOG_LENGTH;

import java.awt.BorderLayout;
import java.awt.Frame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL2ES2;
//import com.jogamp.media.opengl.*; updated package from import javax.media.opengl.*;
//import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
public class HelloPoint  extends Frame implements GLEventListener{
	private static final long serialVersionUID = 1L;
	static int HEIGHT = 600, WIDTH = 600;
	static GL2 gl;
	static GLCanvas myCanvas;
	static GLCapabilities capabilities;
	
	public HelloPoint() {
		//drawable = myCanvas
		capabilities = new GLCapabilities(GLProfile.get(GLProfile.GL2));
		myCanvas = new GLCanvas();
		
		//reshape event listener for canvas
		myCanvas.addGLEventListener(this);
		
		//fill Frame container with drawble myCanvas
		this.add(myCanvas, BorderLayout.CENTER);
		
		//OpenGL interface
		gl = (GL2) myCanvas.getGL();
		
	}
	
	public static void main(String[] args) {
		HelloPoint Frame = new HelloPoint();
		
		
		Frame.setSize(HEIGHT, WIDTH);
		Frame.setVisible(true);
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glPointSize(10);
		gl.glBegin(GL2.GL_POINTS);
		gl.glVertex2i(WIDTH/2, HEIGHT/2);
		gl.glEnd();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl.glColor3f(1.0f, 0.0f, 0.0f); //depracated in lieu of GLSL vec4 shaders
		/*GL4 gl = (GL4) GLContext.getCurrentGL();
		float bkg[] = {0.0f, 0.0f, 0.0f, 1.0f}; //clear background after every frame
		FloatBuffer bkgBuffer = Buffers.newDirectFloatBuffer(bkg);
		gl.glClearBufferfv(GL_COLOR, 1, bkgBuffer);
		gl.glClear(GL_DEPTH_BUFFER_BIT);*/
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		//handling protocol for window reshaping
		WIDTH = width;
		HEIGHT = height;
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, width, 0, height, -1.0, 1.0);
	}
	
	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
		
	}

	//*Debug Runtime and Errors Log for OpenGL and GLSL
		private void printShaderLog(int shader) {
			GL2 gl = (GL2) GLContext.getCurrentGL();
			int[] len = new int[1];
			int[] chWrittn = new int[1];
			byte[] log = null;
			
			//determine the length of the shader compilation log
			((GL2ES2) gl).glGetShaderiv(shader, GL_INFO_LOG_LENGTH, len, 0);
			if(len[0] > 0) {
				log = new byte[len[0]];
				((GL2ES2) gl).glGetShaderInfoLog(shader, len[0], chWrittn, 0, log, 0);
				System.out.println("Shader Info Log: ");
				for(int i = 0; i < log.length; i++) {
					System.out.print((char) log[i]);
				}
			}
		}
		
		void printProgramLog(int prog) {
			GL2 gl = (GL2) GLContext.getCurrentGL();
			int[] len = new int[1];
			int[] chWrittn = new int[1];
			byte[] log = null;
			
			//determine the length of the program linking log
			((GL2ES2) gl).glGetProgramiv(prog, GL_INFO_LOG_LENGTH, len, 0);
			System.out.println("Program Info Log: ");
			for(int i = 0; i < log.length; i++) {
				System.out.print((char) log[i]);
			}
		}
		
		boolean checkOpenGLError() {
			GL2 gl = (GL2) GLContext.getCurrentGL();
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
