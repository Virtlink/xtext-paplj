/*
 * generated by Xtext 2.11.0
 */
package org.metaborg.paplj.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.metaborg.paplj.services.PapljGrammarAccess;

@SuppressWarnings("all")
public class PapljSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PapljGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Block2_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_Field_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_Import_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_PrimaryExpr_LeftParenthesisKeyword_7_0_a;
	protected AbstractElementAlias match_PrimaryExpr_LeftParenthesisKeyword_7_0_p;
	protected AbstractElementAlias match_Program_SemicolonKeyword_0_2_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PapljGrammarAccess) access;
		match_Block2_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getBlock2Access().getSemicolonKeyword_3());
		match_Field_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getFieldAccess().getSemicolonKeyword_2());
		match_Import_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getImportAccess().getSemicolonKeyword_2());
		match_PrimaryExpr_LeftParenthesisKeyword_7_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExprAccess().getLeftParenthesisKeyword_7_0());
		match_PrimaryExpr_LeftParenthesisKeyword_7_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExprAccess().getLeftParenthesisKeyword_7_0());
		match_Program_SemicolonKeyword_0_2_q = new TokenAlias(false, true, grammarAccess.getProgramAccess().getSemicolonKeyword_0_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Block2_SemicolonKeyword_3_q.equals(syntax))
				emit_Block2_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Field_SemicolonKeyword_2_q.equals(syntax))
				emit_Field_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Import_SemicolonKeyword_2_q.equals(syntax))
				emit_Import_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PrimaryExpr_LeftParenthesisKeyword_7_0_a.equals(syntax))
				emit_PrimaryExpr_LeftParenthesisKeyword_7_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PrimaryExpr_LeftParenthesisKeyword_7_0_p.equals(syntax))
				emit_PrimaryExpr_LeftParenthesisKeyword_7_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Program_SemicolonKeyword_0_2_q.equals(syntax))
				emit_Program_SemicolonKeyword_0_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '('* '{' (ambiguity) '}' (rule start)
	 *     (rule start) '{' (ambiguity) '}' (rule start)
	 *     exprs+=Expr (ambiguity) '}' (rule end)
	 */
	protected void emit_Block2_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_Field_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     importedNamespace=QualifiedNameWithWildcard (ambiguity) (rule end)
	 */
	protected void emit_Import_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' expr=UnaryExpr
	 *     (rule start) (ambiguity) '-' expr=UnaryExpr
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'if' '(' condition=Expr
	 *     (rule start) (ambiguity) 'let' 'in' expr=Expr
	 *     (rule start) (ambiguity) 'let' bindings+=Binding
	 *     (rule start) (ambiguity) 'new' type=[Type|QualifiedName]
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) 'null' type=[Type|ID]
	 *     (rule start) (ambiguity) 'this' (rule start)
	 *     (rule start) (ambiguity) '{' ';'? '}' (rule start)
	 *     (rule start) (ambiguity) '{' exprs+=Expr
	 *     (rule start) (ambiguity) member=[Symbol|ID]
	 *     (rule start) (ambiguity) true?='true'
	 *     (rule start) (ambiguity) value=INT
	 *     (rule start) (ambiguity) {Add.left=}
	 *     (rule start) (ambiguity) {And.left=}
	 *     (rule start) (ambiguity) {Assignment.left=}
	 *     (rule start) (ambiguity) {Cast.left=}
	 *     (rule start) (ambiguity) {Div.left=}
	 *     (rule start) (ambiguity) {Eq.left=}
	 *     (rule start) (ambiguity) {Lt.left=}
	 *     (rule start) (ambiguity) {MemberRef.left=}
	 *     (rule start) (ambiguity) {Mul.left=}
	 *     (rule start) (ambiguity) {Neq.left=}
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {Sub.left=}
	 */
	protected void emit_PrimaryExpr_LeftParenthesisKeyword_7_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' expr=UnaryExpr
	 *     (rule start) (ambiguity) '-' expr=UnaryExpr
	 *     (rule start) (ambiguity) 'if' '(' condition=Expr
	 *     (rule start) (ambiguity) 'let' 'in' expr=Expr
	 *     (rule start) (ambiguity) 'let' bindings+=Binding
	 *     (rule start) (ambiguity) {Add.left=}
	 *     (rule start) (ambiguity) {And.left=}
	 *     (rule start) (ambiguity) {Assignment.left=}
	 *     (rule start) (ambiguity) {Cast.left=}
	 *     (rule start) (ambiguity) {Div.left=}
	 *     (rule start) (ambiguity) {Eq.left=}
	 *     (rule start) (ambiguity) {Lt.left=}
	 *     (rule start) (ambiguity) {MemberRef.left=}
	 *     (rule start) (ambiguity) {Mul.left=}
	 *     (rule start) (ambiguity) {Neq.left=}
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {Sub.left=}
	 */
	protected void emit_PrimaryExpr_LeftParenthesisKeyword_7_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QualifiedName (ambiguity) 'run' expr=Expr
	 *     name=QualifiedName (ambiguity) (rule end)
	 *     name=QualifiedName (ambiguity) classes+=Type
	 *     name=QualifiedName (ambiguity) imports+=Import
	 */
	protected void emit_Program_SemicolonKeyword_0_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
