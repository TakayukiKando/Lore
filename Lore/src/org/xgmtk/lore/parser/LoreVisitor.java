// Generated from C:\Users\kando\git\Lore\Lore\src\org\xgmtk\lore\parser\Lore.g4 by ANTLR 4.1
package org.xgmtk.lore.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LoreParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LoreVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LoreParser#enum_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum_field(@NotNull LoreParser.Enum_fieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#jid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJid(@NotNull LoreParser.JidContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(@NotNull LoreParser.RelationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(@NotNull LoreParser.LambdaContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_no_param_no_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_no_param_no_return(@NotNull LoreParser.Lambda_no_param_no_returnContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(@NotNull LoreParser.TermsContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXml(@NotNull LoreParser.XmlContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#section_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection_element(@NotNull LoreParser.Section_elementContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull LoreParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#docinfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocinfo(@NotNull LoreParser.DocinfoContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#range_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange_type(@NotNull LoreParser.Range_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersion(@NotNull LoreParser.VersionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#list_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_type(@NotNull LoreParser.List_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#member_initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_initializer(@NotNull LoreParser.Member_initializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#as_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs_block(@NotNull LoreParser.As_blockContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_expr(@NotNull LoreParser.Type_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#type_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_def(@NotNull LoreParser.Type_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull LoreParser.StringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#procedure_apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_apply(@NotNull LoreParser.Procedure_applyContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type(@NotNull LoreParser.Lambda_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_type_no_param_no_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type_no_param_no_return(@NotNull LoreParser.Lambda_type_no_param_no_returnContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#loc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoc(@NotNull LoreParser.LocContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(@NotNull LoreParser.RangeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#form_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_def(@NotNull LoreParser.Form_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#select_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_statement(@NotNull LoreParser.Select_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#shortStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortStringLiteral(@NotNull LoreParser.ShortStringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_type_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type_parameters(@NotNull LoreParser.Lambda_type_parametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#builtin_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin_type_expr(@NotNull LoreParser.Builtin_type_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_type_no_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type_no_param(@NotNull LoreParser.Lambda_type_no_paramContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#post_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPost_op(@NotNull LoreParser.Post_opContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull LoreParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#enum_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum_def(@NotNull LoreParser.Enum_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#alter_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_def(@NotNull LoreParser.Alter_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#dice_monomial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDice_monomial(@NotNull LoreParser.Dice_monomialContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_spec(@NotNull LoreParser.Type_specContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#integral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegral(@NotNull LoreParser.IntegralContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#unit_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit_def(@NotNull LoreParser.Unit_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#result_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_statement(@NotNull LoreParser.Result_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull LoreParser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull LoreParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#cond_monomial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_monomial(@NotNull LoreParser.Cond_monomialContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#enum_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum_elem(@NotNull LoreParser.Enum_elemContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(@NotNull LoreParser.UrlContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(@NotNull LoreParser.InitializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#function_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_def(@NotNull LoreParser.Function_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#trpg_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrpg_type(@NotNull LoreParser.Trpg_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#cond_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_term(@NotNull LoreParser.Cond_termContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#extends_from}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtends_from(@NotNull LoreParser.Extends_fromContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(@NotNull LoreParser.SelfContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#form_cont_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_cont_def(@NotNull LoreParser.Form_cont_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_type_full}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type_full(@NotNull LoreParser.Lambda_type_fullContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull LoreParser.AtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(@NotNull LoreParser.DateContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#field_modify}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_modify(@NotNull LoreParser.Field_modifyContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_full}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_full(@NotNull LoreParser.Lambda_fullContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#arithmetic_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_type(@NotNull LoreParser.Arithmetic_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#select_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_expr(@NotNull LoreParser.Select_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(@NotNull LoreParser.SectionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#default_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefault_block(@NotNull LoreParser.Default_blockContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_type_no_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_type_no_return(@NotNull LoreParser.Lambda_type_no_returnContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#monomial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonomial(@NotNull LoreParser.MonomialContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#member_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_access(@NotNull LoreParser.Member_accessContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#simpleCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCall(@NotNull LoreParser.SimpleCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_parameters(@NotNull LoreParser.Lambda_parametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decl(@NotNull LoreParser.Field_declContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#accessor_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor_def(@NotNull LoreParser.Accessor_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml(@NotNull LoreParser.HtmlContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#unitName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitName(@NotNull LoreParser.UnitNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#author}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthor(@NotNull LoreParser.AuthorContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#history}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHistory(@NotNull LoreParser.HistoryContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#real}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(@NotNull LoreParser.RealContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#encoding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEncoding(@NotNull LoreParser.EncodingContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#list_construct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_construct(@NotNull LoreParser.List_constructContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_no_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_no_return(@NotNull LoreParser.Lambda_no_returnContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull LoreParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(@NotNull LoreParser.HeaderContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#case_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_block(@NotNull LoreParser.Case_blockContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(@NotNull LoreParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#qName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQName(@NotNull LoreParser.QNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLore(@NotNull LoreParser.LoreContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#rule_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_def(@NotNull LoreParser.Rule_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#private_section_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivate_section_element(@NotNull LoreParser.Private_section_elementContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(@NotNull LoreParser.DescriptionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#unit_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit_type(@NotNull LoreParser.Unit_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull LoreParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#form_contents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_contents(@NotNull LoreParser.Form_contentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(@NotNull LoreParser.DefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#form_construct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_construct(@NotNull LoreParser.Form_constructContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull LoreParser.FactorContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#diceKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiceKind(@NotNull LoreParser.DiceKindContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_block(@NotNull LoreParser.Lambda_blockContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#import_other}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_other(@NotNull LoreParser.Import_otherContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#unit_monomial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit_monomial(@NotNull LoreParser.Unit_monomialContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#textual_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextual_type(@NotNull LoreParser.Textual_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull LoreParser.ArgsContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#member_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_def(@NotNull LoreParser.Member_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#builtin_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin_type(@NotNull LoreParser.Builtin_typeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#var_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def(@NotNull LoreParser.Var_defContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#simpleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleName(@NotNull LoreParser.SimpleNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#lambda_no_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda_no_param(@NotNull LoreParser.Lambda_no_paramContext ctx);

	/**
	 * Visit a parse tree produced by {@link LoreParser#private_member_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivate_member_def(@NotNull LoreParser.Private_member_defContext ctx);
}