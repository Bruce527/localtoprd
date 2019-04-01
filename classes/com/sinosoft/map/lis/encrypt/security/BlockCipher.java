// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BlockCipher.java

package com.sinosoft.map.lis.encrypt.security;


// Referenced classes of package com.sinosoft.map.lis.encrypt.security:
//			CryptoError

public abstract class BlockCipher
{

	public BlockCipher()
	{
	}

	public final void encrypt(byte text[])
	{
		encrypt(text, text);
	}

	public final void decrypt(byte text[])
	{
		decrypt(text, text);
	}

	public final void encrypt(byte in[], byte out[])
	{
		int len = blockLength();
		if (in.length != len || out.length != len)
		{
			throw new CryptoError((new StringBuilder(String.valueOf(getClass().getName()))).append(": encrypt buffers must be the same size as cipher length").toString());
		} else
		{
			encrypt(in, 0, out, 0);
			return;
		}
	}

	public final void decrypt(byte in[], byte out[])
	{
		int len = blockLength();
		if (in.length != len || out.length != len)
		{
			throw new CryptoError((new StringBuilder(String.valueOf(getClass().getName()))).append(": decrypt buffers must be the same size as cipher length").toString());
		} else
		{
			decrypt(in, 0, out, 0);
			return;
		}
	}

	public final void encrypt(byte in[], int in_offset, byte out[], int out_offset)
	{
		int blkLength = blockLength();
		if (in_offset < 0 || out_offset < 0)
			throw new ArrayIndexOutOfBoundsException((new StringBuilder(String.valueOf(getClass().getName()))).append(": Negative offset not allowed").toString());
		if (in_offset + blkLength > in.length || out_offset + blkLength > out.length)
		{
			throw new ArrayIndexOutOfBoundsException((new StringBuilder(String.valueOf(getClass().getName()))).append(": Offset past end of array").toString());
		} else
		{
			blockEncrypt(in, in_offset, out, out_offset);
			return;
		}
	}

	public final void decrypt(byte in[], int in_offset, byte out[], int out_offset)
	{
		int blkLength = blockLength();
		if (in_offset < 0 || out_offset < 0)
			throw new ArrayIndexOutOfBoundsException((new StringBuilder(String.valueOf(getClass().getName()))).append(": Negative offset not allowed").toString());
		if (in_offset + blkLength > in.length || out_offset + blkLength > out.length)
		{
			throw new ArrayIndexOutOfBoundsException((new StringBuilder(String.valueOf(getClass().getName()))).append(": Offset past end of array").toString());
		} else
		{
			blockDecrypt(in, in_offset, out, out_offset);
			return;
		}
	}

	protected abstract void blockEncrypt(byte abyte0[], int i, byte abyte1[], int j);

	protected abstract void blockDecrypt(byte abyte0[], int i, byte abyte1[], int j);

	public abstract int blockLength();

	public abstract int keyLength();
}
