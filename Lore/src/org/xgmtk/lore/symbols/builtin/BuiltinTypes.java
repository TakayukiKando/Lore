package org.xgmtk.lore.symbols.builtin;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.xgmtk.lore.symbols.FormDef;
import org.xgmtk.lore.symbols.Scope;
import org.xgmtk.lore.symbols.Scope.AlreadyDefinedSymbolException;

public class BuiltinTypes {
	private static final NumberType[] numbers = {new IntType(),
	new RealType()};
	
	private static final BuiltinType[] builtins = {
	new StringType(),
	new DateType(),
	new DiceType(),
	new LocatorType(),
	new HTMLType(),
	new JIDType(),
	new XMLType(),
	new URLType()
	};
	
	private static final FormDef[] predefinedFormDefs ={
		new FormDef(FormDef.ROOT_TYPE)
	};

	private static final FormDef[] extended;
	
	static{
		Stream<FormDef> r = Arrays.stream(numbers).map(n->new RangeType(n));
		Stream<FormDef> u = Arrays.stream(numbers).map(n->new UnitBaseType(n));
		extended = Stream.concat(r, u).toArray(size->new FormDef[size]);
	}
	
	public static FormDef[] allSymbols() {
		return Stream.concat(Arrays.stream(predefinedFormDefs), Stream.concat(
			Stream.concat(Arrays.stream(numbers), Arrays.stream(builtins)),
			Arrays.stream(extended))).toArray(size->new FormDef[size]);
	}

	public static <T> Optional<BuiltinType> findBuiltinType(Class<T> valueClass){
//		System.err.println("Find: \""+valueClass.getName()+"\" from: ");
//		Stream.concat(Arrays.stream(numbers), Arrays.stream(builtins)).forEach(def->System.err.println("\t\""+def.getValueClass().getName()+"\"."));
		return Stream.concat(Arrays.stream(numbers), Arrays.stream(builtins)).filter(def->def.getValueClass()==valueClass).findAny();
	}
	
	public static void defineAll(Scope scope) throws AlreadyDefinedSymbolException{
		scope.defineAll(allSymbols());
	}
}
