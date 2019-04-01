// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IDEA.java

package com.sinosoft.map.lis.encrypt.security;

import java.io.PrintStream;

// Referenced classes of package com.sinosoft.map.lis.encrypt.security:
//			BlockCipher, CryptoError

public final class IDEA extends BlockCipher
{

	private static final String LIBRARY_NAME = "idea";
	private static boolean native_link_ok = false;
	private static boolean native_lib_loaded = false;
	private static String native_link_err = "Class never loaded";
	public static final int BLOCK_LENGTH = 8;
	public static final int KEY_LENGTH = 16;
	private static final int INTERNAL_KEY_LENGTH = 104;
	private static final int KEYS_PER_ROUND = 6;
	private static final int ROUNDS = 8;
	private int ks[];
	private int dks[];

	public static boolean hasFileLibraryLoaded()
	{
		return native_lib_loaded;
	}

	public static boolean isLibraryCorrect()
	{
		return native_link_ok;
	}

	public static String getLinkErrorString()
	{
		return native_link_err;
	}

	public int blockLength()
	{
		return 8;
	}

	public int keyLength()
	{
		return 16;
	}

	public IDEA(byte userKey[])
	{
		dks = null;
		if (userKey.length != 16)
			throw new CryptoError("Idea: User key length wrong");
		if (native_link_ok)
			native_ks(userKey);
		else
			java_ks(userKey);
	}

	private static int mul(int a, int b)
	{
		a &= 0xffff;
		b &= 0xffff;
		if (a != 0)
		{
			if (b != 0)
			{
				int p = a * b;
				b = p & 0xffff;
				a = p >>> 16;
				return (b - a) + (b >= a ? 0 : 1) & 0xffff;
			} else
			{
				return 1 - a & 0xffff;
			}
		} else
		{
			return 1 - b & 0xffff;
		}
	}

	private static int inv(int x)
	{
		x &= 0xffff;
		if (x <= 1)
			return x;
		int t1 = 0x10001 / x;
		int y = 0x10001 % x;
		if (y == 1)
			return 1 - t1 & 0xffff;
		int t0 = 1;
		do
		{
			int q = x / y;
			x %= y;
			t0 = t0 + q * t1 & 0xffff;
			if (x == 1)
				return t0;
			q = y / x;
			y %= x;
			t1 += q * t0;
		} while (y != 1);
		return 1 - t1 & 0xffff;
	}

	private void java_ks(byte userKey[])
	{
		ks = new int[52];
		int i;
		for (i = 0; i < 8; i++)
			ks[i] = (userKey[i * 2] & 0xff) << 8 | userKey[i * 2 + 1] & 0xff;

		int j = 0;
		int koff = 0;
		for (; i < 52; i++)
		{
			j++;
			ks[koff + j + 7] = (ks[koff + (j & 7)] << 9 | ks[koff + (j + 1 & 7)] >>> 7) & 0xffff;
			koff += j & 8;
			j &= 7;
		}

	}

	private void java_dks()
	{
		int j = 0;
		dks = new int[52];
		dks[48] = inv(ks[j++]);
		dks[49] = -ks[j++];
		dks[50] = -ks[j++];
		dks[51] = inv(ks[j++]);
		for (int i = 42; i >= 0; i -= 6)
		{
			dks[i + 4] = ks[j++];
			dks[i + 5] = ks[j++];
			dks[i + 0] = inv(ks[j++]);
			if (i > 0)
			{
				dks[i + 2] = -ks[j++];
				dks[i + 1] = -ks[j++];
			} else
			{
				dks[i + 1] = -ks[j++];
				dks[i + 2] = -ks[j++];
			}
			dks[i + 3] = inv(ks[j++]);
		}

	}

	private static void java_encrypt(byte in[], int in_offset, byte out[], int out_offset, int key[])
	{
		int k = 0;
		int x0 = in[in_offset++] << 8;
		x0 |= in[in_offset++] & 0xff;
		int x1 = in[in_offset++] << 8;
		x1 |= in[in_offset++] & 0xff;
		int x2 = in[in_offset++] << 8;
		x2 |= in[in_offset++] & 0xff;
		int x3 = in[in_offset++] << 8;
		x3 |= in[in_offset] & 0xff;
		int t0;
		for (int i = 0; i < 8; i++)
		{
			x0 = mul(x0, key[k++]);
			x1 += key[k++];
			x2 += key[k++];
			x3 = mul(x3, key[k++]);
			t0 = x2;
			x2 = mul(x0 ^ x2, key[k++]);
			int t1 = x1;
			x1 = mul((x1 ^ x3) + x2, key[k++]);
			x2 += x1;
			x0 ^= x1;
			x3 ^= x2;
			x1 ^= t0;
			x2 ^= t1;
		}

		x0 = mul(x0, key[k++]);
		t0 = x1;
		x1 = x2 + key[k++];
		x2 = t0 + key[k++];
		x3 = mul(x3, key[k]);
		out[out_offset++] = (byte)(x0 >>> 8);
		out[out_offset++] = (byte)x0;
		out[out_offset++] = (byte)(x1 >>> 8);
		out[out_offset++] = (byte)x1;
		out[out_offset++] = (byte)(x2 >>> 8);
		out[out_offset++] = (byte)x2;
		out[out_offset++] = (byte)(x3 >>> 8);
		out[out_offset] = (byte)x3;
	}

	protected void blockEncrypt(byte in[], int in_offset, byte out[], int out_offset)
	{
		if (ks == null)
			throw new CryptoError("Idea: User key not set.");
		if (native_link_ok)
			native_encrypt(in, in_offset, out, out_offset, ks);
		else
			java_encrypt(in, in_offset, out, out_offset, ks);
	}

	protected void blockDecrypt(byte in[], int in_offset, byte out[], int out_offset)
	{
		if (dks == null)
		{
			dks = new int[52];
			if (native_link_ok)
				native_dks();
			else
				java_dks();
		}
		if (native_link_ok)
			native_encrypt(in, in_offset, out, out_offset, dks);
		else
			java_encrypt(in, in_offset, out, out_offset, dks);
	}

	public void native_ks(byte userKey[])
	{
		java_ks(userKey);
	}

	public void native_dks()
	{
		java_dks();
	}

	public void native_encrypt(byte abyte0[], int i, byte abyte1[], int j, int ai[])
	{
	}

	private static synchronized native int idea_test();

	private static synchronized native void idea_ks(byte abyte0[]);

	private static synchronized native void idea_dks();

	private static synchronized native void idea_encrypt(byte abyte0[], int i, byte abyte1[], int j, byte abyte2[]);

	public static void self_test(PrintStream out, String argv[])
		throws Exception
	{
		test(out, "00010002000300040005000600070008", "0000000100020003", "11FBED2B01986DE5");
		test(out, "0005000A000F00140019001E00230028", "0102030405060708", "3EC04780BEFF6E20");
		test(out, "3A984E2000195DB32EE501C8C47CEA60", "0102030405060708", "97BCD8200780DA86");
		test(out, "006400C8012C019001F4025802BC0320", "05320A6414C819FA", "65BE87E7A2538AED");
		test(out, "9D4075C103BC322AFB03E7BE6AB30006", "0808080808080808", "F5DB1AC45E5EF9F9");
	}

	private static void test(PrintStream out, String keyStr, String plainStr, String cipherStr)
	{
		byte key[] = fromString(keyStr);
		byte plain[] = fromString(plainStr);
		byte cipher[] = fromString(cipherStr);
		IDEA idea = new IDEA(key);
		byte encP[] = new byte[plain.length];
		byte decC[] = new byte[plain.length];
		idea.encrypt(plain, encP);
		String a;
		String b;
		out.println((new StringBuilder("plain:")).append(toString(plain)).append(" enc:").append(a = toString(encP)).append(" calc:").append(b = toString(cipher)).toString());
		if (a.equals(b))
			out.println("encryption good");
		else
			out.println(" ********* IDEA ENC FAILED ********* ");
		idea.decrypt(encP, decC);
		out.println((new StringBuilder("  enc:")).append(toString(encP)).append(" dec:").append(a = toString(decC)).append(" calc:").append(b = toString(plain)).toString());
		if (a.equals(b))
			out.println("decryption good");
		else
			out.println(" ********* IDEA DEC FAILED ********* ");
	}

	private static byte[] fromString(String inHex)
	{
		int len = inHex.length();
		int pos = 0;
		byte buffer[] = new byte[(len + 1) / 2];
		if (len % 2 == 1)
		{
			buffer[0] = (byte)asciiToHex(inHex.charAt(0));
			pos = 1;
			len--;
		}
		int ptr = pos;
		for (; len > 0; len -= 2)
			buffer[pos++] = (byte)(asciiToHex(inHex.charAt(ptr++)) << 4 | asciiToHex(inHex.charAt(ptr++)));

		return buffer;
	}

	private static String toString(byte buffer[])
	{
		StringBuffer returnBuffer = new StringBuffer();
		int pos = 0;
		for (int len = buffer.length; pos < len; pos++)
			returnBuffer.append(hexToAscii(buffer[pos] >>> 4 & 0xf)).append(hexToAscii(buffer[pos] & 0xf));

		return returnBuffer.toString();
	}

	private static int asciiToHex(char c)
	{
		if (c >= 'a' && c <= 'f')
			return (c - 97) + 10;
		if (c >= 'A' && c <= 'F')
			return (c - 65) + 10;
		if (c >= '0' && c <= '9')
			return c - 48;
		else
			throw new Error("ascii to hex failed");
	}

	private static char hexToAscii(int h)
	{
		if (h >= 10 && h <= 15)
			return (char)(65 + (h - 10));
		if (h >= 0 && h <= 9)
			return (char)(48 + h);
		else
			throw new Error("hex to ascii failed");
	}

	public static void main(String args[])
	{
	}

	static 
	{
		try
		{
			System.loadLibrary("idea");
			native_lib_loaded = true;
			try
			{
				if (idea_test() == 0)
				{
					native_link_ok = true;
					native_link_err = null;
				} else
				{
					native_link_err = "Self test failed";
				}
			}
			catch (UnsatisfiedLinkError ule)
			{
				native_link_err = "Errors linking to idea native library";
			}
		}
		catch (UnsatisfiedLinkError ule)
		{
			native_link_err = "The idea native library was not found";
		}
	}
}
