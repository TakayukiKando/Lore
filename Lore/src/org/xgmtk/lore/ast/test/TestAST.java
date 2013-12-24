package org.xgmtk.lore.ast.test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xgmtk.lore.ast.AST;

public class TestAST {
	private static AST abcd;
	private static AST abcd2;
	private static AST abcde;

	private static AST tree(String name, AST...subtrees){
		return new AST(name, subtrees);
	}
	
	@BeforeClass
	static public void setupStatics(){
		abcd = tree("abcd", 
				tree("a"), 
				tree("bcd", 
						tree("bc", 
								tree("b"), 
								tree("c")
						), 
						tree("d")
				)
		);
		abcd2 = tree("abcd", 
				tree("a"), 
				tree("bcd", 
						tree("bc", 
								tree("b"), 
								tree("c")
						), 
						tree("d")
				)
		);
		abcde = tree("abcd", 
				tree("a"), 
				tree("bcd", 
						tree("bc", 
								tree("b"), 
								tree("c")
						), 
						tree("d"),
						tree("e")
				)
		);
	}
	
	@Test
	public void testIterator(){
		Iterator<AST> it = abcd.iterator();
		StringBuilder log = new StringBuilder();
		while(it.hasNext()){
			AST t = it.next();
			log.append(t.name).append(";");
		}
		String expectedLog = "abcd;a;abcd;bcd;bc;b;bc;c;bc;bcd;d;bcd;abcd;";

		assertThat(log.toString(), is(expectedLog));
	}
	
	@Test
	public void testVisitor(){
		class TVisitor implements AST.Visitor{
			public final StringBuilder log = new StringBuilder();
			
			@Override
			public void enter(AST node){
				log.append(node.name).append("(");
			}
			
			@Override
			public void exit(AST node){
				log.append(")");
			}
		}
		
		TVisitor visitor = new TVisitor();
		abcd.visit(visitor);
		
		String expectedLog = "abcd(a()bcd(bc(b()c())d()))";

		assertThat(visitor.log.toString(), is(expectedLog));
	}
	
	@Test
	public void testEqualsAndHashCode(){
		assertThat(abcd.equals(abcd2), is(true));
		assertThat(abcd.equals(abcd), is(true));
		assertThat(abcd2.equals(abcd), is(true));
		
		assertThat(abcd.hashCode(), is(abcd2.hashCode()));
		assertThat(abcd.hashCode(), is(abcd.hashCode()));
		assertThat(abcd2.hashCode(), is(abcd.hashCode()));

		assertThat(abcd.equals(abcde), is(false));
		assertThat(abcde.equals(abcd), is(false));
		assertThat(abcd.equals(null), is(false));
		
		assertThat(abcd.hashCode() == abcde.hashCode(), is(false));
	}
}
