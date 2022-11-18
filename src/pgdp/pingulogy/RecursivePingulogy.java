package pgdp.pingulogy;

public class RecursivePingulogy {

	static int i = 0;
	static int counter = 0;

	static long[] testarr;
	static long[] testarr1;
	public static long hey(int n, int p0, int p1, int p2) {
		// TODO
		if (p0 == 0 && p1 == 0 && p2 == 0  ) {
			return 0;
		}

		if (n == 0) {
			return p0;
		}
		if (n == 1) {
			return p1;
		}
		if (n == 2) {
			return p2;
		}

		if (n <= 0) {//negativ
			int i = n;
			i = -1 * i;

			{
				if (testarr1[i] != 0) {
					return testarr1[i];
				}
				long n1 = 2 * hey(-1 * n, p0, p1, p2);
				testarr1[i] = n1;
				return n1;
			}
		}
		else {//positiv
			if (n < p0 || n < p1 || n < p2) {
				return n;
			}
			else {
				if (testarr[n] != 0) {
					return testarr[n];
				}
				long n2 = hey(n - 1, p0, p1, p2) - hey(n - 2, p0, p1, p2) + 2 * hey(n - 3, p0, p1, p2);
				testarr[n] = n2;
				return n2;
			}
		}
	}
	// task 1
	public static long pinguSequenceRec(int n, int p0, int p1, int p2) {
		// TODO
		 testarr = new long[146];
		 testarr1 = new long[146];
		return hey(n, p0, p1, p2);
	}


	// task 2
	// Hint: pinguF and pinguM are not static (and must not be changed to it!)
	// more information in the main-method below

	public int pinguF(int n) {
		// TODO

		if (n == 0) {
			n = 1;
			return n;
		}
		else {
			return n - pinguM(pinguF(n - 1));
		}
	}

	public int pinguM(int n) {
		// TODO
		if (n == 0) {
			return n;
		}
		else {
			return n - pinguF(pinguM(n - 1));
		}
	}

	static int ze = 0;
	// task 3
	public static int pinguCode(int n, int m) {
		// TODO
		int summe;
		if (n == 0) {
			int ze1 = ze;
			ze = 0;
			summe = m + ze1;
			return summe;
		}
		int vergleich = ze + n;
		if (vergleich % 2 == 0) {//wenn gerade
				ze += (n / 2);
				return pinguCode(m, n / 2);
		}
		else {//Wenn ungerade
				ze += m;
				return pinguCode(n - 1, m / 2);
			}

		}
	// task 4
	//static int zahler = 0;
	public static String pinguDNA(int f, int m) {
		// TODO
		if (f == 0 && m == 0) {
			return "";
		}
		else if (f == 0 && m != 0) {
			m /= 2;
			return pinguDNA(f, m) + "A";
		}
		else if (f != 0 && m == 0) {
			f /= 2;
			return pinguDNA(f, m) + "T";

		}
		else {
			if ((f % 2 == 0 && m % 2 == 0) || (f % 2 != 0 && m % 2 != 0) ) {//Wenn mit selben Bit-Wert am Ende
				if (f > m) {

					return pinguDNA(f /= 2, m /= 2) + "GT";
				}
				else if (f < m) {

					return pinguDNA(f /= 2, m /= 2) + "GA";
				}
				else {//f == m

					return pinguDNA(f /= 2, m /= 2) + "GC";
				}
			}
			else if (f % 2 != 0 && m % 2 == 0) {//Wenn f ungerade

				return pinguDNA(f /= 2, m /= 2) + "TC";
			}
			else {//Wenn m ungerade
				return pinguDNA(f /= 2, m /= 2) + "AC";
			}
		}
	}

	public static void main(String[] args) {
		// switch value to test other tasks
		int testTask = 1;

		switch (testTask) {
		case 1:
			System.out.println("Task 1 example output");
			for (int i = 0; i < 145; i++) {
				System.out.println(i + ": " + pinguSequenceRec(i, 1, 1, 2));
			}
			break;
		case 2:
			/**
			 * For better testing, pinguF and pinguM are not static. 
			 * Hence, you have to initialize a new RecursivePingulogy Object and 
			 * call the methods on that instance, as you can see below.
			 * You will learn more about object-oriented-programming in the lecture
			 * and week 05+.
			 */
			RecursivePingulogy rp = new RecursivePingulogy();
			System.out.print("Task 2 example output\npinguF: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguF(i) + ", ");
			}
			System.out.print("\npingM: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguM(i) + ", ");
			}
			break;
		case 3:
			System.out.println("Task 3 example output");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.println(i + ", " + j + ": " + pinguCode(i, j));
				}
				System.out.println("----------");
			}
			break;
		case 4:
			System.out.println("Task 4 example output");
			System.out.println("pinguDNA(21, 25) = " + pinguDNA(0, 2));
			break;
		default:
			System.out.println("There are only 4 tasks!");
			break;
		}
	}
}
