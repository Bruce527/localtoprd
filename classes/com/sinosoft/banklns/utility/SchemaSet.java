// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SchemaSet.java

package com.sinosoft.banklns.utility;


// Referenced classes of package com.sinosoft.banklns.utility:
//			CError, CErrors, Schema

public class SchemaSet
{

	private Object elementData[];
	private int elementCount;
	private int capacityIncrement;
	public CErrors mErrors;

	public SchemaSet(int initialCapacity, int capacityIncrement)
	{
		if (initialCapacity < 0)
		{
			CError tError = new CError();
			tError.moduleName = "SchemaSet";
			tError.functionName = "SchemaSet";
			tError.errorMessage = (new StringBuilder("Illegal Capacity: ")).append(initialCapacity).toString();
			mErrors.addOneError(tError);
		}
		elementData = new Object[initialCapacity];
		this.capacityIncrement = capacityIncrement;
		elementCount = 0;
		mErrors = new CErrors();
	}

	public SchemaSet(int initialCapacity)
	{
		this(initialCapacity, 0);
	}

	public SchemaSet()
	{
		this(10);
	}

	public boolean add(Schema aSchema)
	{
		if (aSchema == null)
		{
			return false;
		} else
		{
			ensureCapacityHelper(elementCount + 1);
			elementData[elementCount] = aSchema;
			elementCount++;
			return true;
		}
	}

	public boolean add(SchemaSet aSet)
	{
		if (aSet == null)
			return false;
		int n = aSet.size();
		ensureCapacityHelper(elementCount + n);
		for (int i = 0; i < n; i++)
			elementData[elementCount + i] = aSet.getObj(i + 1);

		elementCount += n;
		return true;
	}

	public boolean remove(Schema aSchema)
	{
		if (aSchema == null)
			return false;
		for (int i = 0; i < elementCount; i++)
			if (aSchema.equals(elementData[i]))
			{
				int j = elementCount - i - 1;
				if (j > 0)
					System.arraycopy(((Object) (elementData)), i + 1, ((Object) (elementData)), i, j);
				elementCount--;
				elementData[elementCount] = null;
				return true;
			}

		return false;
	}

	public boolean removeRange(int begin, int end)
	{
		if (begin <= 0 || end > elementCount || begin > end)
			return false;
		int n = elementCount - end;
		if (n > 0)
			System.arraycopy(((Object) (elementData)), end, ((Object) (elementData)), begin - 1, elementCount - end);
		int m = (end - begin) + 1;
		for (int i = 1; i <= m; i++)
		{
			int j = elementCount - i;
			elementData[j] = null;
		}

		elementCount -= m;
		return true;
	}

	public void clear()
	{
		for (int i = 0; i < elementCount; i++)
			elementData[i] = null;

		elementCount = 0;
	}

	public Object getObj(int index)
	{
		if (index > elementCount)
		{
			CError tError = new CError();
			tError.moduleName = "SchemaSet";
			tError.functionName = "get";
			tError.errorMessage = "Index out of bounds!";
			mErrors.addOneError(tError);
		}
		return elementData[index - 1];
	}

	public boolean set(int index, Schema aSchema)
	{
		if (index > elementCount)
		{
			CError tError = new CError();
			tError.moduleName = "SchemaSet";
			tError.functionName = "set";
			tError.errorMessage = "Index out of bounds!";
			mErrors.addOneError(tError);
			return false;
		} else
		{
			elementData[index - 1] = aSchema;
			return true;
		}
	}

	public boolean set(SchemaSet aSet)
	{
		clear();
		return add(aSet);
	}

	public int size()
	{
		return elementCount;
	}

	private void ensureCapacityHelper(int minCapacity)
	{
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity)
		{
			Object oldData[] = elementData;
			int newCapacity = capacityIncrement <= 0 ? oldCapacity * 2 : oldCapacity + capacityIncrement;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			elementData = new Object[newCapacity];
			System.arraycopy(((Object) (oldData)), 0, ((Object) (elementData)), 0, elementCount);
		}
	}
}
