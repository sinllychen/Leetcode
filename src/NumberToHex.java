
public class NumberToHex {
	char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	public String toHex1(int num) {
		if(num == 0) return "0";
		String result = "";
		while(num != 0){
			result = map[(num & 0xF)] + result; 
			num = (num >>> 4);
		}
		return result;
	}
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		int MAX = 32;
		boolean isNegative = false;
		int bits[] = new int[MAX];
		if (num < 0) {
			isNegative = true;
			bits[MAX - 1] = 1;
			num = -num;
		}

		int i = 0;
		// 转化为二进制的原码
		while (num > 0) {
			bits[i++] = num % 2;
			num /= 2;
		}

		// 如果是负数，需要取反并且+1从而得到补码
		if (isNegative) {
			// 取反
			for (int j = 0; j < bits.length - 1; j++) {
				bits[j] = (bits[j] + 1) % 2;
			}
			// +1
			int digit = 1;
			int res = 0;
			for (int j = 0; j < bits.length - 1; j++) {
				res = bits[j] + digit;
				bits[j] = res % 2;
				digit = res / 2;
			}
		}

		// 二进制转化为十六进制
		String ret = "";
		for (int j = 0; j < bits.length; j += 4) {
			int data = 0;
			for (int j2 = 0; j2 < 4; j2++) {
				data += bits[j + j2] * (1 << j2);
			}
			ret = String.format("%x", data) + ret;
		}

		// 去掉字符串前面多余的0
		for (int j = 0; j < ret.length(); j++) {
			if (ret.charAt(j) != '0') {
				ret = ret.substring(j);
				break;
			}
		}

		return ret;
	}
	public static void main(String[] args)
	{
		NumberToHex test = new NumberToHex();
		System.out.println(test.toHex(-1));
	}
}
