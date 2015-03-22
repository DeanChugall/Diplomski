import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.UnsupportedAudioFileException;

import com.dean.chugall.Recognito;
import com.dean.chugall.VocalPrint;

public class hghhh {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException {

		Recognito<String> recognito = new Recognito<String>();

		/*VocalPrint print = recognito.createVocalPrint("Bill Gates", new File(
				"Bill.wav"));
		VocalPrint print1 = recognito.createVocalPrint("Elvis2", new File(
				"LukeSyson_2013X.wav"));
		
		VocalPrint print3 = recognito.createVocalPrint("TALE", new File(
				"TALE1.wav"));
		VocalPrint print4 = recognito.createVocalPrint("MAMA", new File(
				"MAMA-1.wav"));
		VocalPrint print5 = recognito.createVocalPrint("DEA", new File(
				"dea1.wav"));

		VocalPrint print6 = recognito.createVocalPrint("Nikad vise", new File(
				"B 3 - Nikad vise.wav"));
		VocalPrint print7 = recognito.createVocalPrint("Toto-Africa", new File(
				"02-toto-africa.wav"));*/

		VocalPrint print9 = recognito.createVocalPrint("Sergey Brin", new File(
				"C:\\Users\\Dean\\Desktop\\recognito-master\\recognito\\src\\main\\Sergey Brin.wav"));

        VocalPrint print10 = recognito.createVocalPrint("RHCP", new File(
                "C:\\Users\\Dean\\Desktop\\recognito-master\\recognito\\src\\main\\1.wav"));
        VocalPrint print11 = recognito.createVocalPrint("wod", new File(
                "C:\\Users\\Dean\\Desktop\\recognito-master\\recognito\\src\\main\\wood-cracking-2.wav"));
        VocalPrint print12 = recognito.createVocalPrint("taleeeeee", new File(
                "C:\\Users\\Dean\\Desktop\\recognito-master\\recognito\\src\\main\\Tale.wav"));

		
		// handle persistence the way you want, e.g.:
		// myUser.setVocalPrint(print);
		// userDao.saveOrUpdate(myUser);

		// Now check if the King is back

		//List<String> matches = recognito.recognize(new File("C:\\Users\\Dean\\Desktop\\recognito-master\\recognito\\src\\main\\Sergey BrinYT.wav"));
        List<String> matches1 = recognito.recognize(new File("C:\\Users\\Dean\\Desktop\\recognito-master\\recognito\\src\\main\\tale2.wav"));
		//List<String> matches1 = recognito.recognize(new File("LukeSyson_2013X.wav"));
		System.out.println("Sergey Brin is back : " + matches1.get(0).equals("Sergey Brin"));
		System.out.println("RHCP : " + matches1.get(0).equals("RHCP"));
        System.out.println("wood is back : " + matches1.get(0).equals("TALE"));
        System.out.println("taleeeeeeeeee : " + matches1.get(0).equals("taleeeeee"));
		/*System.out.println("Elvis3 is back : " + matches.get(0).equals("Elvis3"));
		System.out.println("TALE is back : " + matches.get(0).equals("TALE"));
		System.out.println("MAMA is back : " + matches.get(0).equals("MAMA"));
		System.out.println("DEA is back : " + matches.get(0).equals("DEA"));
		System.out.println("Nikad vise : " + matches.get(0).equals("Nikad vise"));
		System.out.println("Toto-Africa : " + matches.get(0).equals("Toto-Africa"));
		System.out.println("1 : " + matches.get(0).equals("1"));*/
		
	}

}
