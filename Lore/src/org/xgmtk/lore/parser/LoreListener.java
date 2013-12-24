// Generated from C:\Users\kando\git\Lore\Lore\src\org\xgmtk\lore\parser\Lore.g4 by ANTLR 4.1
package org.xgmtk.lore.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LoreParser}.
 */
public interface LoreListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull LoreParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull LoreParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull LoreParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull LoreParser.AtomContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull LoreParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull LoreParser.ArgsContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(@NotNull LoreParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(@NotNull LoreParser.TermsContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(@NotNull LoreParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(@NotNull LoreParser.StringLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#form_def}.
	 * @param ctx the parse tree
	 */
	void enterForm_def(@NotNull LoreParser.Form_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#form_def}.
	 * @param ctx the parse tree
	 */
	void exitForm_def(@NotNull LoreParser.Form_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#lore}.
	 * @param ctx the parse tree
	 */
	void enterLore(@NotNull LoreParser.LoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#lore}.
	 * @param ctx the parse tree
	 */
	void exitLore(@NotNull LoreParser.LoreContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(@NotNull LoreParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(@NotNull LoreParser.LambdaContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#list_type}.
	 * @param ctx the parse tree
	 */
	void enterList_type(@NotNull LoreParser.List_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#list_type}.
	 * @param ctx the parse tree
	 */
	void exitList_type(@NotNull LoreParser.List_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#monomial}.
	 * @param ctx the parse tree
	 */
	void enterMonomial(@NotNull LoreParser.MonomialContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#monomial}.
	 * @param ctx the parse tree
	 */
	void exitMonomial(@NotNull LoreParser.MonomialContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(@NotNull LoreParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(@NotNull LoreParser.DescriptionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#alter_def}.
	 * @param ctx the parse tree
	 */
	void enterAlter_def(@NotNull LoreParser.Alter_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#alter_def}.
	 * @param ctx the parse tree
	 */
	void exitAlter_def(@NotNull LoreParser.Alter_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#jid}.
	 * @param ctx the parse tree
	 */
	void enterJid(@NotNull LoreParser.JidContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#jid}.
	 * @param ctx the parse tree
	 */
	void exitJid(@NotNull LoreParser.JidContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull LoreParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull LoreParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#select_expr}.
	 * @param ctx the parse tree
	 */
	void enterSelect_expr(@NotNull LoreParser.Select_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#select_expr}.
	 * @param ctx the parse tree
	 */
	void exitSelect_expr(@NotNull LoreParser.Select_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#member_access}.
	 * @param ctx the parse tree
	 */
	void enterMember_access(@NotNull LoreParser.Member_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#member_access}.
	 * @param ctx the parse tree
	 */
	void exitMember_access(@NotNull LoreParser.Member_accessContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#enum_def}.
	 * @param ctx the parse tree
	 */
	void enterEnum_def(@NotNull LoreParser.Enum_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#enum_def}.
	 * @param ctx the parse tree
	 */
	void exitEnum_def(@NotNull LoreParser.Enum_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#result_statement}.
	 * @param ctx the parse tree
	 */
	void enterResult_statement(@NotNull LoreParser.Result_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#result_statement}.
	 * @param ctx the parse tree
	 */
	void exitResult_statement(@NotNull LoreParser.Result_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(@NotNull LoreParser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(@NotNull LoreParser.Var_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#builtin_type}.
	 * @param ctx the parse tree
	 */
	void enterBuiltin_type(@NotNull LoreParser.Builtin_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#builtin_type}.
	 * @param ctx the parse tree
	 */
	void exitBuiltin_type(@NotNull LoreParser.Builtin_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull LoreParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull LoreParser.ConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#case_block}.
	 * @param ctx the parse tree
	 */
	void enterCase_block(@NotNull LoreParser.Case_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#case_block}.
	 * @param ctx the parse tree
	 */
	void exitCase_block(@NotNull LoreParser.Case_blockContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(@NotNull LoreParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(@NotNull LoreParser.RelationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#loc}.
	 * @param ctx the parse tree
	 */
	void enterLoc(@NotNull LoreParser.LocContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#loc}.
	 * @param ctx the parse tree
	 */
	void exitLoc(@NotNull LoreParser.LocContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull LoreParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull LoreParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#xml}.
	 * @param ctx the parse tree
	 */
	void enterXml(@NotNull LoreParser.XmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#xml}.
	 * @param ctx the parse tree
	 */
	void exitXml(@NotNull LoreParser.XmlContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#procedure_apply}.
	 * @param ctx the parse tree
	 */
	void enterProcedure_apply(@NotNull LoreParser.Procedure_applyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#procedure_apply}.
	 * @param ctx the parse tree
	 */
	void exitProcedure_apply(@NotNull LoreParser.Procedure_applyContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#type_expr}.
	 * @param ctx the parse tree
	 */
	void enterType_expr(@NotNull LoreParser.Type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#type_expr}.
	 * @param ctx the parse tree
	 */
	void exitType_expr(@NotNull LoreParser.Type_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(@NotNull LoreParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(@NotNull LoreParser.UrlContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(@NotNull LoreParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(@NotNull LoreParser.HeaderContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#as_block}.
	 * @param ctx the parse tree
	 */
	void enterAs_block(@NotNull LoreParser.As_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#as_block}.
	 * @param ctx the parse tree
	 */
	void exitAs_block(@NotNull LoreParser.As_blockContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull LoreParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull LoreParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#member_initializer}.
	 * @param ctx the parse tree
	 */
	void enterMember_initializer(@NotNull LoreParser.Member_initializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#member_initializer}.
	 * @param ctx the parse tree
	 */
	void exitMember_initializer(@NotNull LoreParser.Member_initializerContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#enum_field}.
	 * @param ctx the parse tree
	 */
	void enterEnum_field(@NotNull LoreParser.Enum_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#enum_field}.
	 * @param ctx the parse tree
	 */
	void exitEnum_field(@NotNull LoreParser.Enum_fieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#docinfo}.
	 * @param ctx the parse tree
	 */
	void enterDocinfo(@NotNull LoreParser.DocinfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#docinfo}.
	 * @param ctx the parse tree
	 */
	void exitDocinfo(@NotNull LoreParser.DocinfoContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#post_op}.
	 * @param ctx the parse tree
	 */
	void enterPost_op(@NotNull LoreParser.Post_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#post_op}.
	 * @param ctx the parse tree
	 */
	void exitPost_op(@NotNull LoreParser.Post_opContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#range_type}.
	 * @param ctx the parse tree
	 */
	void enterRange_type(@NotNull LoreParser.Range_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#range_type}.
	 * @param ctx the parse tree
	 */
	void exitRange_type(@NotNull LoreParser.Range_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterField_decl(@NotNull LoreParser.Field_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitField_decl(@NotNull LoreParser.Field_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelect_statement(@NotNull LoreParser.Select_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#select_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelect_statement(@NotNull LoreParser.Select_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(@NotNull LoreParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(@NotNull LoreParser.RangeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#section_element}.
	 * @param ctx the parse tree
	 */
	void enterSection_element(@NotNull LoreParser.Section_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#section_element}.
	 * @param ctx the parse tree
	 */
	void exitSection_element(@NotNull LoreParser.Section_elementContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#qName}.
	 * @param ctx the parse tree
	 */
	void enterQName(@NotNull LoreParser.QNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#qName}.
	 * @param ctx the parse tree
	 */
	void exitQName(@NotNull LoreParser.QNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull LoreParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull LoreParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(@NotNull LoreParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(@NotNull LoreParser.DateContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#version}.
	 * @param ctx the parse tree
	 */
	void enterVersion(@NotNull LoreParser.VersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#version}.
	 * @param ctx the parse tree
	 */
	void exitVersion(@NotNull LoreParser.VersionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#author}.
	 * @param ctx the parse tree
	 */
	void enterAuthor(@NotNull LoreParser.AuthorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#author}.
	 * @param ctx the parse tree
	 */
	void exitAuthor(@NotNull LoreParser.AuthorContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#struct_construct}.
	 * @param ctx the parse tree
	 */
	void enterStruct_construct(@NotNull LoreParser.Struct_constructContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#struct_construct}.
	 * @param ctx the parse tree
	 */
	void exitStruct_construct(@NotNull LoreParser.Struct_constructContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#enum_elem}.
	 * @param ctx the parse tree
	 */
	void enterEnum_elem(@NotNull LoreParser.Enum_elemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#enum_elem}.
	 * @param ctx the parse tree
	 */
	void exitEnum_elem(@NotNull LoreParser.Enum_elemContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#type_def}.
	 * @param ctx the parse tree
	 */
	void enterType_def(@NotNull LoreParser.Type_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#type_def}.
	 * @param ctx the parse tree
	 */
	void exitType_def(@NotNull LoreParser.Type_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#member_def}.
	 * @param ctx the parse tree
	 */
	void enterMember_def(@NotNull LoreParser.Member_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#member_def}.
	 * @param ctx the parse tree
	 */
	void exitMember_def(@NotNull LoreParser.Member_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#encoding}.
	 * @param ctx the parse tree
	 */
	void enterEncoding(@NotNull LoreParser.EncodingContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#encoding}.
	 * @param ctx the parse tree
	 */
	void exitEncoding(@NotNull LoreParser.EncodingContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#unit_def}.
	 * @param ctx the parse tree
	 */
	void enterUnit_def(@NotNull LoreParser.Unit_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#unit_def}.
	 * @param ctx the parse tree
	 */
	void exitUnit_def(@NotNull LoreParser.Unit_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#list_construct}.
	 * @param ctx the parse tree
	 */
	void enterList_construct(@NotNull LoreParser.List_constructContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#list_construct}.
	 * @param ctx the parse tree
	 */
	void exitList_construct(@NotNull LoreParser.List_constructContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#private_member_def}.
	 * @param ctx the parse tree
	 */
	void enterPrivate_member_def(@NotNull LoreParser.Private_member_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#private_member_def}.
	 * @param ctx the parse tree
	 */
	void exitPrivate_member_def(@NotNull LoreParser.Private_member_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(@NotNull LoreParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(@NotNull LoreParser.DefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#function_def}.
	 * @param ctx the parse tree
	 */
	void enterFunction_def(@NotNull LoreParser.Function_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#function_def}.
	 * @param ctx the parse tree
	 */
	void exitFunction_def(@NotNull LoreParser.Function_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull LoreParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull LoreParser.FactorContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#cond_monomial}.
	 * @param ctx the parse tree
	 */
	void enterCond_monomial(@NotNull LoreParser.Cond_monomialContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#cond_monomial}.
	 * @param ctx the parse tree
	 */
	void exitCond_monomial(@NotNull LoreParser.Cond_monomialContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#accessor_def}.
	 * @param ctx the parse tree
	 */
	void enterAccessor_def(@NotNull LoreParser.Accessor_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#accessor_def}.
	 * @param ctx the parse tree
	 */
	void exitAccessor_def(@NotNull LoreParser.Accessor_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#default_block}.
	 * @param ctx the parse tree
	 */
	void enterDefault_block(@NotNull LoreParser.Default_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#default_block}.
	 * @param ctx the parse tree
	 */
	void exitDefault_block(@NotNull LoreParser.Default_blockContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(@NotNull LoreParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(@NotNull LoreParser.SectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#history}.
	 * @param ctx the parse tree
	 */
	void enterHistory(@NotNull LoreParser.HistoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#history}.
	 * @param ctx the parse tree
	 */
	void exitHistory(@NotNull LoreParser.HistoryContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#constant_var_def}.
	 * @param ctx the parse tree
	 */
	void enterConstant_var_def(@NotNull LoreParser.Constant_var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#constant_var_def}.
	 * @param ctx the parse tree
	 */
	void exitConstant_var_def(@NotNull LoreParser.Constant_var_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull LoreParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull LoreParser.TermContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#cond_term}.
	 * @param ctx the parse tree
	 */
	void enterCond_term(@NotNull LoreParser.Cond_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#cond_term}.
	 * @param ctx the parse tree
	 */
	void exitCond_term(@NotNull LoreParser.Cond_termContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#private_section_element}.
	 * @param ctx the parse tree
	 */
	void enterPrivate_section_element(@NotNull LoreParser.Private_section_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#private_section_element}.
	 * @param ctx the parse tree
	 */
	void exitPrivate_section_element(@NotNull LoreParser.Private_section_elementContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#lambda_type}.
	 * @param ctx the parse tree
	 */
	void enterLambda_type(@NotNull LoreParser.Lambda_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#lambda_type}.
	 * @param ctx the parse tree
	 */
	void exitLambda_type(@NotNull LoreParser.Lambda_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#arithmetic_type}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_type(@NotNull LoreParser.Arithmetic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#arithmetic_type}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_type(@NotNull LoreParser.Arithmetic_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#field_modify}.
	 * @param ctx the parse tree
	 */
	void enterField_modify(@NotNull LoreParser.Field_modifyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#field_modify}.
	 * @param ctx the parse tree
	 */
	void exitField_modify(@NotNull LoreParser.Field_modifyContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtml(@NotNull LoreParser.HtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtml(@NotNull LoreParser.HtmlContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#unit_type}.
	 * @param ctx the parse tree
	 */
	void enterUnit_type(@NotNull LoreParser.Unit_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#unit_type}.
	 * @param ctx the parse tree
	 */
	void exitUnit_type(@NotNull LoreParser.Unit_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#builtin_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterBuiltin_type_expr(@NotNull LoreParser.Builtin_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#builtin_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitBuiltin_type_expr(@NotNull LoreParser.Builtin_type_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#import_other}.
	 * @param ctx the parse tree
	 */
	void enterImport_other(@NotNull LoreParser.Import_otherContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#import_other}.
	 * @param ctx the parse tree
	 */
	void exitImport_other(@NotNull LoreParser.Import_otherContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#rule_def}.
	 * @param ctx the parse tree
	 */
	void enterRule_def(@NotNull LoreParser.Rule_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#rule_def}.
	 * @param ctx the parse tree
	 */
	void exitRule_def(@NotNull LoreParser.Rule_defContext ctx);

	/**
	 * Enter a parse tree produced by {@link LoreParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull LoreParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoreParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull LoreParser.LiteralContext ctx);
}