
import java.util.ResourceBundle.Control;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AprioriTest {

	public static void main(String[] args) throws IOException {

		Scanner Sc = new Scanner(System.in);
		
    	File file = new File("girdiler.txt");
    	BufferedReader okuyucu = null;
    	okuyucu = new BufferedReader(new FileReader(file));
    	String satir = okuyucu.readLine();
    
    	int i = 0;
    	
    	Transaction Urunler = new Transaction();
        
    	while (satir!=null) {// URUNLERÝ BAGLI LÝSTEYE YAZDIK
        	if(i >= 2){
        		if(satir.contains("T")){
        			Urunler.elemanEkle(satir, "");
        		}
        		else
        			Urunler.son.items = satir;
        		}
        satir = okuyucu.readLine();
        i++;
        }
    	Urunler.Listele();
    	ItemTutucu itemlar = new ItemTutucu();
    	Transaction Gezici = new Transaction();
    	Gezici.ilk = Urunler.ilk;
    	int sayiDegeri; 
    	sayiDegeri=itemlar.KacItemVar(Gezici);
    	System.out.println("Toplam item Sayisi = " +sayiDegeri);
    	itemlar.elemanEkle(sayiDegeri);
    	Gezici.ilk = Urunler.ilk;
    	
    	
    	while(Gezici.ilk != null){
    		if(Gezici.ilk.items.contains("1")){
    			itemlar.ilk.ItemName = "I1";
    			itemlar.ilk.I++;
    		}
    		if(Gezici.ilk.items.contains("2")){
    			itemlar.ilk.next.ItemName = "I2";
    			itemlar.ilk.next.I++;
    		}
    		if(Gezici.ilk.items.contains("3")){
    			itemlar.ilk.next.next.ItemName = "I3";
    			itemlar.ilk.next.next.I++;
    		}
    		if(Gezici.ilk.items.contains("4")){
    			itemlar.ilk.next.next.next.ItemName = "I4";
    			itemlar.ilk.next.next.next.I++;
    		}
    		if(Gezici.ilk.items.contains("5")){
    			itemlar.ilk.next.next.next.next.ItemName = "I5";
    			itemlar.ilk.next.next.next.next.I++;
    		}
    		if(Gezici.ilk.items.contains("6")){
    			itemlar.ilk.next.next.next.next.next.ItemName = "I6";
    			itemlar.ilk.next.next.next.next.next.I++;
    		}
    		if(Gezici.ilk.items.contains("7")){
    			itemlar.ilk.next.next.next.next.next.next.ItemName = "I7";
    			itemlar.ilk.next.next.next.next.next.next.I++;
    		}
    		if(Gezici.ilk.items.contains("8")){
    			itemlar.ilk.next.next.next.next.next.next.next.ItemName = "I8";
    			itemlar.ilk.next.next.next.next.next.next.next.I++;
    		}
    		Gezici.ilk = Gezici.ilk.next;
    	}
    		
    	itemlar.Listele();
    	int SupportuSaglayan=0, Support; double Confidence;
    	System.out.println("Lütfen Min Support Degerini giriniz");
    	Support = Sc.nextInt();
    	System.out.println("Lütfen Min confidence Degerini giriniz");
    	Confidence = Sc.nextInt();
    	ItemTutucu Controller = new ItemTutucu();
    	ItemTutucu SupporttuSaglayanItemlar = new ItemTutucu();
    	Controller.ilk = itemlar.ilk;
    	while(Controller.ilk != null){
    		if(Controller.ilk.I >= Support)
    			SupportuSaglayan++;
    		Controller.ilk = Controller.ilk.next;
    	}
    	System.out.println("Supportu Saglayan item sayisi = " + SupportuSaglayan);
    	SupporttuSaglayanItemlar.elemanEkle(SupportuSaglayan);
    	Controller.ilk = itemlar.ilk;
    	ItemTutucu Controller2 = new ItemTutucu();
    	Controller2.ilk = SupporttuSaglayanItemlar.ilk;
    	while(Controller.ilk != null){
    		if(Controller.ilk.I >= Support){
    			Controller2.ilk.I = Controller.ilk.I;
    			Controller2.ilk.ItemName=Controller.ilk.ItemName;
    			Controller2.ilk = Controller2.ilk.next;
    		}
    		Controller.ilk = Controller.ilk.next;
    	}
    	SupporttuSaglayanItemlar.Listele();
    	ItemTutucu Controller3 = new ItemTutucu();
    	ItemTutucu Controller4 = new ItemTutucu();
    	Controller3.ilk = SupporttuSaglayanItemlar.ilk;
    	Controller4.ilk = SupporttuSaglayanItemlar.ilk;
    	Gezici.ilk = Urunler.ilk;
    	ItemTutucu Ikililer = new ItemTutucu();

    	while(Controller3.ilk.next!=null){
    		Controller4.ilk = SupporttuSaglayanItemlar.ilk;
    		while(Controller4.ilk != null){
    			int sayi1=0;
    			Gezici.ilk = Urunler.ilk;
    			while(Gezici.ilk != null)
    			{
    				if(Gezici.ilk.items.contains(Controller3.ilk.ItemName) && Gezici.ilk.items.contains(Controller4.ilk.ItemName))
    				{
    					sayi1++;
    					if(Gezici.ilk.next == null){
    						if(sayi1 >= Support){
    							if(Controller3.ilk.ItemName != Controller4.ilk.ItemName){
    							ItemTutucu Ikililer2 = new ItemTutucu();
    							Ikililer2 = Ikililer;
    							Ikililer2.elemanEkle();
    							Ikililer2.son.I = sayi1;
    							Ikililer2.son.ItemName= Controller3.ilk.ItemName+ " " +Controller4.ilk.ItemName;
    						//System.out.println(Ikililer2.son.ItemName+Ikililer2.son.I);
    							}
    							
    						}
    					}
    				}
    				Gezici.ilk = Gezici.ilk.next;
    			}
    			Controller4.ilk = Controller4.ilk.next;
    		}
    		Controller3.ilk = Controller3.ilk.next;
    	}
	
    	Ikililer.Listele();
    	Ikililer.Ayir();
    	
    	ItemTutucu Ucluler = new ItemTutucu();
    	ItemTutucu IkililerinGezicisi = new ItemTutucu();
    	IkililerinGezicisi.ilk = Ikililer.ilk;
    	Gezici.ilk = Urunler.ilk;

    	while(IkililerinGezicisi.ilk.next.next != null){
    		int tutucu = 0;
    		 Gezici.ilk=Urunler.ilk;
    		while(Gezici.ilk != null){//1 3 6
    			
    		if(Gezici.ilk.items.contains((IkililerinGezicisi.ilk.Itemlar[0])) && 
    				Gezici.ilk.items.contains(IkililerinGezicisi.ilk.Itemlar[1])){
    			if(Gezici.ilk.items.contains(IkililerinGezicisi.ilk.next.Itemlar[0]) || 
    					Gezici.ilk.items.contains(IkililerinGezicisi.ilk.next.Itemlar[1])){
    				if(((IkililerinGezicisi.ilk.next.Itemlar[0].equals(IkililerinGezicisi.ilk.Itemlar[0])) == false) 
    						&&((IkililerinGezicisi.ilk.next.Itemlar[0].equals(IkililerinGezicisi.ilk.Itemlar[1]))==false) 
    						|| ((IkililerinGezicisi.ilk.next.Itemlar[1].equals(IkililerinGezicisi.ilk.Itemlar[0]))==false ) 
    						&& ((IkililerinGezicisi.ilk.next.Itemlar[1].equals(IkililerinGezicisi.ilk.Itemlar[1]))==false)
    						){
    							tutucu++;
    							if(tutucu >= Support){
    							
    								Ucluler.elemanEkle();
    								Ucluler.son.I = tutucu;
    								if((IkililerinGezicisi.ilk.ItemName.contains(IkililerinGezicisi.ilk.next.Itemlar[0]))){
    									Ucluler.son.ItemName = IkililerinGezicisi.ilk.ItemName + " "+ IkililerinGezicisi.ilk.next.Itemlar[1];
    								}
    								else{
    									Ucluler.son.ItemName =  IkililerinGezicisi.ilk.ItemName+" "+IkililerinGezicisi.ilk.next.Itemlar[0] ;

    								}
    								}
    							}
    				}
    			
    				
    			}
    				
    		
    	
    		
    		Gezici.ilk = Gezici.ilk.next;
    		}

    		IkililerinGezicisi.ilk = IkililerinGezicisi.ilk.next;
    	}
		Ucluler.Listele();
		Ucluler.Ayir();
		System.out.println("Uclulerin ayný olanlarý düzenleyip yeni baglý liste olusturuyoruz. ve esas 3 lülere ulasýyoruz::\n");
		Ucluler = Ucluler.UcluleriAyarla();
		Ucluler.Listele();
		Ucluler.Ayir();
		// sýra geldi confidence e;
		//Conf algoritmasý
		double geciciTrans=0;
		System.out.println("Deðerli Kurallar = \n");
		Transaction ak = new Transaction();
		ak.ilk = Urunler.ilk;
		geciciTrans = 0;
		double degerliOran = 0;
		Gezici.ilk = Urunler.ilk;
		while(Ucluler.ilk != null){
		while(Gezici.ilk != null){
			if(Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[0])){
				geciciTrans++;
			}
			Gezici.ilk = Gezici.ilk.next; 
		}
		degerliOran = Ucluler.ilk.I / geciciTrans;
		if(degerliOran >= Confidence){
			System.out.println(Ucluler.ilk.Itemlar[0] + " -> " + Ucluler.ilk.Itemlar[1]+ " v " + Ucluler.ilk.Itemlar[2]);
		}
		
		geciciTrans =0;
		Gezici.ilk = Urunler.ilk;
		while(Gezici.ilk != null){
			if(Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[1])){
				geciciTrans++;
			}
			Gezici.ilk = Gezici.ilk.next; 
		}
		degerliOran = Ucluler.ilk.I / geciciTrans;
		if(degerliOran >= Confidence){
			System.out.println(Ucluler.ilk.Itemlar[1] + " -> " + Ucluler.ilk.Itemlar[0]+ " v " + Ucluler.ilk.Itemlar[2]);
		}
		
		geciciTrans =0;
		Gezici.ilk = Urunler.ilk;
		while(Gezici.ilk != null){
			if(Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[2])){
				geciciTrans++;
			}
			Gezici.ilk = Gezici.ilk.next; 
		}
		degerliOran = Ucluler.ilk.I / geciciTrans;
		if(degerliOran >= Confidence){
			System.out.println(Ucluler.ilk.Itemlar[2] + " -> " + Ucluler.ilk.Itemlar[0]+ " v " + Ucluler.ilk.Itemlar[1]);
		}
		
		geciciTrans =0;
		Gezici.ilk = Urunler.ilk;
		while(Gezici.ilk != null){
			if(Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[0]) && Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[1])){
				geciciTrans++;
			}
			Gezici.ilk = Gezici.ilk.next; 
		}
		degerliOran = Ucluler.ilk.I / geciciTrans;
		if(degerliOran >= Confidence){
			System.out.println(Ucluler.ilk.Itemlar[0] + " v " + Ucluler.ilk.Itemlar[1]+ " -> " + Ucluler.ilk.Itemlar[2]);
		}
		geciciTrans =0;
		Gezici.ilk = Urunler.ilk;
		while(Gezici.ilk != null){
			if(Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[0]) && Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[2])){
				geciciTrans++;
			}
			Gezici.ilk = Gezici.ilk.next; 
		}
		degerliOran = Ucluler.ilk.I / geciciTrans;
		if(degerliOran >= Confidence){
			System.out.println(Ucluler.ilk.Itemlar[0] + " v " + Ucluler.ilk.Itemlar[2]+ " -> " + Ucluler.ilk.Itemlar[1]);
		}
		
		geciciTrans =0;
		Gezici.ilk = Urunler.ilk;
		while(Gezici.ilk != null){
			if(Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[1]) && Gezici.ilk.items.contains(Ucluler.ilk.Itemlar[2])){
				geciciTrans++;
			}
			Gezici.ilk = Gezici.ilk.next; 
		}
		degerliOran = Ucluler.ilk.I / geciciTrans;
		if(degerliOran >= Confidence){
			System.out.println(Ucluler.ilk.Itemlar[1] + " v " + Ucluler.ilk.Itemlar[2]+ " -> " + Ucluler.ilk.Itemlar[0]);
		}
		Ucluler.ilk = Ucluler.ilk.next;
		}
	}
}