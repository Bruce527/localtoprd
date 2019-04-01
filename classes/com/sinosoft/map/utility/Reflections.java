// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Reflections.java

package com.sinosoft.map.utility;

import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Vector;

// Referenced classes of package com.sinosoft.map.utility:
//			SchemaSet, Schema

public class Reflections
{

	Vector mVResult;

	public Reflections()
	{
		mVResult = new Vector();
	}

	public static void printConstructors(Class c1)
	{
		Constructor constructors[] = c1.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++)
		{
			Constructor c = constructors[i];
			String name = c.getName();
			Class aclass[] = c.getParameterTypes();
		}

	}

	public static void printMethods(Class c1)
	{
		java.lang.reflect.Method methods[] = c1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++)
		{
			java.lang.reflect.Method method = methods[i];
		}

	}

	public static void printFields(Class c1)
	{
		Field fields[] = c1.getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
		}

	}

	public boolean transFields(SchemaSet a, SchemaSet b)
	{
		if (a != null)
		{
			int n = b.size();
			try
			{
				Class c1 = a.getObj(1).getClass();
				a.clear();
				for (int i = 1; i <= n; i++)
				{
					Object c = c1.newInstance();
					transFields((Schema)c, (Schema)b.getObj(i));
					a.add((Schema)c);
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		} else
		{
			return false;
		}
		return true;
	}

	public Object transFields(Schema a, Schema b)
	{
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		Field fieldsDest[] = c1.getDeclaredFields();
		Field fieldsOrg[] = c2.getDeclaredFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		AccessibleObject.setAccessible(fieldsOrg, true);
		for (int i = 0; i < fieldsDest.length; i++)
		{
			Field f = fieldsDest[i];
			Class type = f.getType();
			String name = f.getName();
			String typeName = type.getName();
			if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate"))
			{
				for (int j = 0; j < fieldsOrg.length; j++)
				{
					Field f1 = fieldsOrg[j];
					String name1 = f1.getName();
					String typeName1 = type.getName();
					if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate") && typeName.equals(typeName1) && name1.equals(name))
						switch (transType(typeName))
						{
						case 3: // '\003'
							try
							{
								f.setDouble(a, f1.getDouble(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						case 5: // '\005'
							try
							{
								f.setInt(a, f1.getInt(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						case 93: // ']'
							try
							{
								f.set(a, f1.get(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						default:
							try
							{
								f.set(a, f1.get(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;
						}
				}

			}
		}

		return a;
	}

	public Object transFields1(Schema a, Schema b)
	{
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		Field fieldsDest[] = c1.getFields();
		Field fieldsOrg[] = c2.getFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		AccessibleObject.setAccessible(fieldsOrg, true);
		System.out.println((new StringBuilder("----fieldDest.length:")).append(fieldsDest.length).toString());
		System.out.println((new StringBuilder("----fieldsOrg.length:")).append(fieldsOrg.length).toString());
		for (int i = 0; i < fieldsDest.length; i++)
		{
			Field f = fieldsDest[i];
			Class type = f.getType();
			String name = f.getName();
			String typeName = type.getName();
			System.out.println((new StringBuilder("[Time]::")).append(i).append("[colname]:").append(name).append("[Typename]:").append(typeName).toString());
			if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate"))
			{
				for (int j = 0; j < fieldsOrg.length; j++)
				{
					Field f1 = fieldsOrg[j];
					Class type1 = f1.getType();
					String name1 = f1.getName();
					String typeName1 = type1.getName();
					System.out.println((new StringBuilder("[times]:")).append(j).append("[colname1]:").append(name1).append("[Typename1]:").append(typeName1).toString());
					if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate") && typeName.equals(typeName1) && name1.equals(name))
						switch (transType(typeName))
						{
						case 3: // '\003'
							try
							{
								f.setDouble(a, f1.getDouble(b));
							}
							catch (Exception exception) { }
							break;

						case 5: // '\005'
							try
							{
								f.setInt(a, f1.getInt(b));
							}
							catch (Exception exception1) { }
							break;

						case 93: // ']'
							try
							{
								f.set(a, f1.get(b));
							}
							catch (Exception exception2) { }
							break;

						default:
							try
							{
								f.set(a, f1.get(b));
							}
							catch (Exception exception3) { }
							break;
						}
				}

			}
		}

		return a;
	}

	public boolean compareFields(Schema a, Schema b)
	{
		boolean aFlag = true;
		mVResult.clear();
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		Field fieldsDest[] = c1.getDeclaredFields();
		Field fieldsOrg[] = c2.getDeclaredFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		AccessibleObject.setAccessible(fieldsOrg, true);
		for (int i = 0; i < fieldsDest.length; i++)
		{
			Field f = fieldsDest[i];
			Class type = f.getType();
			String name = f.getName();
			String typeName = type.getName();
			if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate"))
			{
				for (int j = 0; j < fieldsOrg.length; j++)
				{
					Field f1 = fieldsOrg[j];
					String name1 = f1.getName();
					String typeName1 = type.getName();
					if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate") && typeName.equals(typeName1) && name1.equals(name))
						switch (transType(typeName))
						{
						case 3: // '\003'
							try
							{
								if (f.getDouble(a) != f1.getDouble(b))
								{
									String tStr = (new StringBuilder(String.valueOf(name))).append("^").append(f.getDouble(a)).append("|").append(f1.getDouble(b)).toString();
									mVResult.addElement(tStr);
									aFlag = false;
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						case 5: // '\005'
							try
							{
								if (f.getInt(a) != f1.getInt(b))
								{
									String tStr = (new StringBuilder(String.valueOf(name))).append("^").append(f.getInt(a)).append("|").append(f1.getInt(b)).toString();
									mVResult.addElement(tStr);
									aFlag = false;
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						case 93: // ']'
							try
							{
								if (f.get(a) != f1.get(b))
								{
									String tStr = (new StringBuilder(String.valueOf(name))).append("^").append(f.get(a)).append("|").append(f1.get(b)).toString();
									mVResult.addElement(tStr);
									aFlag = false;
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						default:
							try
							{
								if (f.get(a) != f1.get(b))
								{
									String tStr = (new StringBuilder(String.valueOf(name))).append("^").append(f.get(a)).append("|").append(f1.get(b)).toString();
									mVResult.addElement(tStr);
									aFlag = false;
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;
						}
				}

			}
		}

		return aFlag;
	}

	public Object synchronizeFields(Schema a, Schema b)
	{
		mVResult.clear();
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		Field fieldsDest[] = c1.getDeclaredFields();
		Field fieldsOrg[] = c2.getDeclaredFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		AccessibleObject.setAccessible(fieldsOrg, true);
		for (int i = 0; i < fieldsDest.length; i++)
		{
			Field f = fieldsDest[i];
			Class type = f.getType();
			String name = f.getName();
			String typeName = type.getName();
			if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate"))
			{
				for (int j = 0; j < fieldsOrg.length; j++)
				{
					Field f1 = fieldsOrg[j];
					String name1 = f1.getName();
					String typeName1 = type.getName();
					if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate") && typeName.equals(typeName1) && name1.equals(name))
						switch (transType(typeName))
						{
						case 3: // '\003'
							try
							{
								if (f.getDouble(a) != f1.getDouble(b))
									f.setDouble(a, f1.getDouble(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						case 5: // '\005'
							try
							{
								if (f.getInt(a) != f1.getInt(b))
									f.setInt(a, f1.getInt(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						case 93: // ']'
							try
							{
								if (f.get(a) != f1.get(b))
									f.set(a, f1.get(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;

						default:
							try
							{
								if (f.get(a) != f1.get(b))
									f.set(a, f1.get(b));
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							break;
						}
				}

			}
		}

		return a;
	}

	public void printFields(Object a)
	{
		Class c1 = a.getClass();
		Field fieldsDest[] = c1.getDeclaredFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		for (int i = 0; i < fieldsDest.length; i++)
		{
			Field f = fieldsDest[i];
			Class type = f.getType();
			String name = f.getName();
			String typeName = type.getName();
			if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate"))
				switch (transType(typeName))
				{
				}
		}

	}

	private static int transType(Object type)
	{
		int typecode = 93;
		if (type.equals("java.lang.String"))
			typecode = 93;
		if (type.equals("double"))
			typecode = 3;
		if (type.equals("int"))
			typecode = 5;
		return typecode;
	}

	public boolean equals(Object otherobject)
	{
		if (this == otherobject)
			return true;
		if (otherobject == null)
			return false;
		if (getClass() != otherobject.getClass())
		{
			return false;
		} else
		{
			Reflections other = (Reflections)otherobject;
			return true;
		}
	}

	public String toString()
	{
		Class ref = getClass();
		return getClass().getName();
	}

	public Vector getVResult()
	{
		return mVResult;
	}

	public static void main(String args1[])
	{
	}
}
