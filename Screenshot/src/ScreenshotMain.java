/**
 * 
 */

/**
 * @author octron
 *
 */
public class ScreenshotMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;
		for (;;) {
			try {
				ShotScreen ss = new ShotScreen("C:/ProgramData/IDM/Nvidia/sc"+Math.random()+"_" +Math.random()+ "_" + i +".jpg");
				ss.getScreenshot(1);
				System.out.println("system OK >>>>>>>>>>");
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}

}
