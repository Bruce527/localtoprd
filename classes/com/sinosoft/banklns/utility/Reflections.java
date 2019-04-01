// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Reflections.java

package com.sinosoft.banklns.utility;

import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Vector;

// Referenced classes of package com.sinosoft.banklns.utility:
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
		System.out.println("------------------print Constructors-----------------");
		for (int i = 0; i < constructors.length; i++)
		{
			Constructor c = constructors[i];
			String name = c.getName();
			System.out.print((new StringBuilder("   ")).append(name).append("(").toString());
			Class paramTypes[] = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
				if (j > 0)
					System.out.print("Par, ");

			System.out.println(");");
		}

	}

	public static void printMethods(Class c1)
	{
		Method methods[] = c1.getDeclaredMethods();
		System.out.println("------------------print methods ----------------");
		for (int i = 0; i < methods.length; i++)
		{
			Method m = methods[i];
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print(Modifier.toString(m.getModifiers()));
			System.out.println((new StringBuilder(" | ")).append(retType.getName()).append(" |").append(name).append("(").toString());
			Class paramTypes[] = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0)
					System.out.print(", ");
				System.out.println(paramTypes[j].getName());
			}

			System.out.println("):");
		}

	}

	public static void printFields(Class c1)
	{
		Field fields[] = c1.getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		System.out.println("------------------print Fields ----------------");
		for (int i = 0; i < fields.length; i++)
		{
			Field f = fields[i];
			Class type = f.getType();
			String name = f.getName();
			System.out.print(Modifier.toString(f.getModifiers()));
			System.out.println((new StringBuilder(" | ")).append(type.getName()).append("| ").append(name).append(";").toString());
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
				System.out.println((new StringBuilder("====in")).append(n).toString());
				for (int i = 1; i <= n; i++)
				{
					System.out.println((new StringBuilder("---i:")).append(i).toString());
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
		System.out.println("------------------trans print Fields ----------------");
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
					Class type1 = f1.getType();
					String name1 = f1.getName();
					String typeName1 = type.getName();
					if (name.equals("FIELDNUM") || name.equals("PK") || name.equals("mErrors") || name.equals("fDate") || !typeName.equals(typeName1) || !name1.equals(name))
						continue;
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
					break;
				}

			}
		}

		System.out.println("----------------------------end-------");
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
		System.out.println("------------------comp print Fields ----------------");
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
					Class type1 = f1.getType();
					String name1 = f1.getName();
					String typeName1 = type.getName();
					if (name.equals("FIELDNUM") || name.equals("PK") || name.equals("mErrors") || name.equals("fDate") || !typeName.equals(typeName1) || !name1.equals(name))
						continue;
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
					break;
				}

			}
		}

		System.out.println("---------------------------- compare end-----------------------");
		return aFlag;
	}

	public Object synchronizeFields(Schema a, Schema b)
	{
		boolean aFlag = true;
		mVResult.clear();
		Class c1 = a.getClass();
		Class c2 = b.getClass();
		Field fieldsDest[] = c1.getDeclaredFields();
		Field fieldsOrg[] = c2.getDeclaredFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		AccessibleObject.setAccessible(fieldsOrg, true);
		System.out.println("------------------comp print Fields ----------------");
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
					Class type1 = f1.getType();
					String name1 = f1.getName();
					String typeName1 = type.getName();
					if (name.equals("FIELDNUM") || name.equals("PK") || name.equals("mErrors") || name.equals("fDate") || !typeName.equals(typeName1) || !name1.equals(name))
						continue;
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
					break;
				}

			}
		}

		System.out.println("---------------------------- compare end-----------------------");
		return a;
	}

	public void printFields(Object a)
	{
		Class c1 = a.getClass();
		Field fieldsDest[] = c1.getDeclaredFields();
		AccessibleObject.setAccessible(fieldsDest, true);
		System.out.println("------------------trans print Fields ----------------");
		for (int i = 0; i < fieldsDest.length; i++)
		{
			Field f = fieldsDest[i];
			Class type = f.getType();
			String name = f.getName();
			String typeName = type.getName();
			if (!name.equals("FIELDNUM") && !name.equals("PK") && !name.equals("mErrors") && !name.equals("fDate"))
				switch (transType(typeName))
				{
				case 3: // '\003'
					try
					{
						System.out.println((new StringBuilder("***************double::")).append(name).append("---").append(f.getDouble(a)).toString());
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					break;

				case 5: // '\005'
					try
					{
						System.out.println((new StringBuilder("*************************Int::")).append(name).append("---").append(f.getInt(a)).toString());
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					break;

				case 93: // ']'
					try
					{
						System.out.println((new StringBuilder("*******************String::")).append(name).append("---").append(f.get(a)).toString());
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					break;

				default:
					try
					{
						System.out.println((new StringBuilder("------Default:")).append(f.get(a)).toString());
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					break;
				}
		}

		System.out.println("-------- print end-------");
	}

	private int transType(Object type)
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
		System.out.println((new StringBuilder("ref:")).append(ref).toString());
		System.out.println("--------------------------");
		return getClass().getName();
	}

	public Vector getVResult()
	{
		return mVResult;
	}

	public static void main(String args[])
	{
		String name;
		if (args.length > 0)
			name = args[0];
		else
			name = "java.util.Date";
		Reflections reflections;
		try
		{
			reflections = new Reflections();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.exit(0);
	}
}
