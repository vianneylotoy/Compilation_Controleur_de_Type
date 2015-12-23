package comp.groupe1.controleurdetype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import comp.groupe1.analyseurMJJ.*;
//import comp.groupe1.interpreteurMJJ.interpreteurMJJVisiteur;

public class controleurType_Minijaja implements MiniJajaVisitor {

	private SimpleNode CurrentNode;
	private Object Obj;

	public HashMap <String, String> ListVars = new HashMap<String, String>();
	public HashMap <String, String> ListMethode = new HashMap<String, String>();
	public HashMap <String, String> ListConstante = new HashMap<String, String>();
	public HashMap <String, String> ListTableau = new HashMap<String, String>();
	public HashMap <String, String> Signaturefct = new HashMap<String, String>();
	public HashMap <String, String> ListVarMeth = new HashMap<String, String>();
	public HashMap <String, String> ListVarLocal = new HashMap<String, String>();
	public HashMap <String, String> ListCstLocal = new HashMap<String, String>();
	public HashMap <String, String> ListTableauLocal = new HashMap<String, String>();
	public HashMap <String, String> ListvarMain = new HashMap<String, String>();
	public HashMap <String, String> ListcstMain = new HashMap<String, String>();
	public HashMap <String, String> ListCompteEntete = new HashMap<String, String>();
	public HashMap <String, String> ListExpEntete = new HashMap<String, String>();
	public HashMap <String, String> ListExpEnteteMain = new HashMap<String, String>();
	public HashMap <String, String> EnteteMethode = new HashMap<String, String>();
	public HashMap <String, String> AppelEMeth = new HashMap<String, String>();
	public HashMap <String, String> AppelEMethMainVars = new HashMap<String, String>();
	public HashMap <String, String> EnTeTeMeThOdE = new HashMap<String, String>();
	public HashMap <String, String> ListCompteEntete1 = new HashMap<String, String>();
	public String Noeuds= "variable";
	public String EnteteMeth = "";
	public String Appel_Courant = "";
	public String Signature_Appel = "";
	public String Retour_Courant = "";
	public String TypeMeth = "";
	public String TypeTableau = "";
	public String varAffTab = "";
	public String varAffTab1 = "";
	public String TypeAffect = "";
	public String valTypeTab = "";
	public String valTypeTab1 = "";
	public ArrayList<String> ListErrors = new ArrayList<String>();
	public ArrayList<String> ListIndiceTab = new ArrayList<String>();
	public ArrayList<String> ListIndiceTabLocal = new ArrayList<String>();
	public ArrayList<String> ListTab = new ArrayList<String>();
	public ArrayList<String> ListcheckTap = new ArrayList<String>();
	public ArrayList<String> ListcheckTap1 = new ArrayList<String>();
	public ArrayList<String> ListIndice = new ArrayList<String>();
	public ArrayList<String> ListValAff = new ArrayList<String>();
	public ArrayList<String> TypeVarLocal = new ArrayList<String>();
	public ArrayList<String> TypeVarEntete = new ArrayList<String>();
	public ArrayList<String> ENTETEMETHAPPel = new ArrayList<String>();
	public ArrayList<String> ENTETEMETHAPPel1 = new ArrayList<String>();
	public ArrayList<String> BBMethode = new ArrayList<String>();
	public ArrayList<String> TypeMethListexp = new ArrayList<String>();
	public ArrayList<String> TypeMethexpMain = new ArrayList<String>();
	public ArrayList<String> TypeMethMainexpAppelEVars = new ArrayList<String>();
	public ArrayList<String> AppelEMethMain = new ArrayList<String>();
	public ArrayList<String> AppelEMain = new ArrayList<String>();
	public ArrayList<String> ListIndice2 = new ArrayList<String>();
	public ArrayList<String> ListcheckTap2 = new ArrayList<String>();


	public String typeVar = "";
	public String typeCst = "";
	public String TypeEntete = ""; 
	public String aa = "";
	public String entet = "";
	public int Vide = 1;
	public String test = "";
	public int VEntete = 0;
	public String  p = "";
	public String Vars = "";
	public int Vnil = 1;
	public String Vn = "";
	public String VNil = "";
	public String context = "";
	public String Tabl = "";
	public String MainMeth = "";
	public String Affectation = "";
	public String nbre = "";
	public String MAIN = "";
	public String TAB = "";
	public String Tableau = "";
	public String INil = "";
	public String identificateur = "";
	public String typetableau = "";
	public String typeIndice = "";
	public String Typemeth = "";
	public String RETOUR = "";
	public String NON = "";
	public int LExp = 0;
	public String ListExp = "";
	public String IdentMet = "";
	public String IdentMetListExp = "";
	public String IdentMethappelE = "";
	public String IdentMetListExpMain = "";
	public String ii = "";
	public String typeApl = "";
	public String Ex = "";
	public String lexp = "";
	public String CC = "";
	public int appeli = 0;
	public String ident = "";
	public String IdentFctMain = "";
	public String VRAI = "";
	public String FAUX = "";
	public String IdentMainAppelI = "";
	public String METHODE = "";
	public String ab1 = "";
	public int leX = 0;
	public int I = 0;
	public int J = 0;
	public int Q = 0;
	public String valExp = "";
	public String aplI = "";
	public String Typentet = "";
	public String IdentAplI = "";
	public String affectApellE =  "";
	public String aplE = "";
	public String IdentAplE = "";
	public String IdentMainAplE = "";
	public String IdentListExAplE = "";
	public String IdentListExAplEVars = "";
	public String IdentAfMainAplE = "";

	public String Variable = "";
	public String VaRs = "";
	public String NomMethode = "";
	public String IdentappelEMainVars = "";
	public String TypeIdentAppelE = "";
	public String ConcTypeNommeth = "";
	public String SI = "";
	public String ET = "";
	public String OU = "";
	public String ADD = "";
	public String SOM = "";
	public String SUB = "";
	public String DIV = "";
	public String MUL = "";
	public String nomEntete = "";
	public String IdEnT = "";
	public String ASTEn = "";
	public String NOD = "";
	public String TypeAffect1 = "";
	public String Table = "";
	public String MaIn = "";
	public String tyPEvaraffect = "";
	public String typedecl = "";
	public String tyPEvaraffectmeth = "";
	public String typedeclmeth = "";
	public String tyPEvaraffectmain = "";
	public String typedeclmain = "";
	//Methode visit
	public String visit(SimpleNode node, Object data){
		CurrentNode = node;
		Obj = data;

		return null;
	}


	//Methode ASTclasse
	public String visit(ASTclasse node, Object data) throws InterpretationException{
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}

		return null;	
	}

	//Methode ASTvar
	public String visit(ASTvar node, Object data) throws InterpretationException{

		String typeIdent = node.jjtGetChild(0).toString();
		String value = node.jjtGetChild(2).toString();
		String pr = node.jjtGetParent().toString();
		String p = Check_Type(typeIdent);
		VNil = "venil";
		Vn = "var";

		if(p.equals("inexistant")){
			ListErrors.add("Erreur: Type de la variable non reconnu!");
			System.out.println("Erreur: Type de la variable non reconnu!");
		}

		else if(value.equals("omega")){
			ListErrors.add("Erreur: la variable n'est pas initialisée!");
			System.out.println("Erreur: la variable n'est pas initialisée!");
		}
		
		else if(p.equals("entier")){
			
			if(!(value.equals("moins") || value.equals("nombre") || value.equals("ident") || value.equals("appelE")
					|| value.equals("somme") || value.equals("addition") || value.equals("soustraction") || value.equals("division")
					|| value.equals("multiplication") || value.equals("tab"))){
				ListErrors.add("Erreur: Type incompatible!");
				System.out.println("Erreur: Type incompatible![var]");
			}
			else{}
		}
		else if(p.equals("boolean")){
			if(!(value.equals("vrai") || value.equals("faux") || value.equals("non"))){
				ListErrors.add("Erreur: Type incompatible!");
				System.out.println("Erreur: Type incompatible!");
			}
			else{}
		}

		else {}

		typeVar = typeIdent;

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;

	}

	//Methode ASTcst
	public String visit(ASTcst node, Object data) throws InterpretationException{
		// TODO Auto-generated method stub

		String type_cst = node.jjtGetChild(0).toString();

		String value_cst = node.jjtGetChild(2).toString();
		String p = Check_Type(type_cst);
		VNil = "venil";
		if(p.equals("inexistant")){
			ListErrors.add("Erreur: Type de la constante non reconnu!");
		}

		else if(value_cst.equals("omega")){
			ListErrors.add("Erreur: la constante n'est pas initialiséeS");
			System.out.println("Erreur: la constante n'est pas initialisée!");

		}

		else if(p.equals("entier")){
			if(!(value_cst.equals("nombre")  || value_cst.equals("ident") || value_cst.equals("moins")|| aplE.equals("appelE")
					|| SOM.equals("somme") || ADD.equals("addition") || SUB.equals("soustraction") || DIV.equals("division")
					|| MUL.equals("multiplication") || TAB.equals("tab"))){
				ListErrors.add("Erreur: Type incompatible!");
				System.out.println("Erreur: Type incompatible![cst]");

			}
			else {}
		}
		else{}

		typeCst = type_cst;

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;

	}


	//Methode ASTmethode	
	public String visit(ASTmethode node, Object data) throws InterpretationException{
		// TODO Auto-generated method stub
		String typeMethIdent = node.jjtGetChild(0).toString();
		String nod = node.jjtGetChild(2).toString();
		METHODE = "methode";
		Noeuds= "methode";
		String a = Check_Type(typeMethIdent);
		if(a.equals("inexistant")){
			ListErrors.add("Erreur: Type de la méthode non reconnu!");
			System.out.println("Erreur: Type de la méthode non reconnu!");
		}

		NOD = nod;
		
		if(nod.equals("enil") && METHODE.equals("methode")){
				int PasEntete = 0;
				String chaine2 = String.valueOf(PasEntete);
				ListCompteEntete1.put(IdentMet, chaine2);
			}
		
		TypeMeth = typeMethIdent;



		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}

		return null;
	}

	//methode ASTentetes
	public String visit(ASTentetes node, Object data) throws InterpretationException{
		// TODO Auto-generated method stub
		
		
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			node.jjtGetChild(i).jjtAccept(this, data);
		}

		return null;
	}

	//Methode ASTenil
	public String visit(ASTenil node, Object data) throws InterpretationException{
		// TODO Auto-generated method stub
		ASTEn = "enil";
		
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			node.jjtGetChild(i).jjtAccept(this, data);
		}

		Vide += 1; 
		p = "enil";
		RETOUR = "";

		VEntete = 0;

		return null;
	}



	//Methode ASTentete
	public String visit(ASTentete node, Object data) throws InterpretationException{
		// TODO Auto-generated method stub
		String Type_Entete = node.jjtGetChild(0).toString();
		Noeuds = "entete";

		test = "entetee"; 
		nomEntete =  "entete";
			TypeEntete = Type_Entete;
			
			
				VEntete +=1;
				String chaine = String.valueOf(VEntete);
				ListCompteEntete.put(IdentMet, chaine);
					

		
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}

		return null;	
	}

	//Methode ASTident
	public String visit(ASTident node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		Tabl = "tableau";
		TAB = "tab";
		identificateur = "IDENT";
		IdEnT = "IDENT";
		String name = node.jjtGetChild(0).toString();
		String n = Noeuds;
		String Pourvar = context;
		String a = node.jjtGetParent().toString();
	

		if(Pourvar.equals("declaration")){

				if(!(n.equals("methode") || Vars.equals("vars"))){
					
						 if(a.equals("var")){		
			                 if(Vn.equals("var")){   
			                	 if(ListVars.containsKey(name)){
									ListErrors.add("Erreur: Variable déjà declarée!");
									System.out.println("Erreur: Variable déjà declarée!"+name);
								}
								else if(ListConstante.containsKey(name)){
									ListErrors.add("Erreur: Variable déjà declarée comme constante!");
									System.out.println("Erreur: Variable déjà declarée comme constante!");
					
								}
								else{
									ListVars.put(name,typeVar);
									typedecl = ListVars.get(name);
							    }
			                 }
			                 else{
			                	 if(!(ListVars.containsKey(name) || ListConstante.containsKey(name))){
										System.out.println("Erreur: Variable indefinie!" +name);

			                	 }
			                	 else{
										tyPEvaraffect = ListVars.get(name);		

			                	 }
			                    }
			                 if(!tyPEvaraffect.isEmpty() && !typedecl.isEmpty()){

								 if(!tyPEvaraffect.equals(typedecl) & identificateur.equals("IDENT")){
									 System.out.println("Erreur: type de variable incompatible [globale]!"+tyPEvaraffect);
								 }
			                 }
			                    Vn = "";
			                    identificateur = "";
					     }
					
					     else if(a.equals("cst")){
		
								if(ListConstante.containsKey(name)){
									ListErrors.add("Erreur: Constante déjà declarée!");
									System.out.println("Erreur: Constante déjà declarée!");
								}
								
								else if(ListVars.containsKey(name)){
									ListErrors.add("Erreur: constante déjà declarée comme var!");
									System.out.println("Erreur: constante déjà declarée comme var!");
									System.out.println(" constante :"+name+"element de la liste Var"+ListVars.get(name));
					
								}
								
								else{
									ListConstante.put(name,typeCst);
								}
				         }
					     else if(Tabl.equals("tableau")){
								if(a.equals("tableau") || nbre.equals("nombre") || DIV.equals("division") || ADD.equals("addition") 
								  || MUL.equals("multiplication") || SUB.equals("soustraction")){
									
								if(ListVars.containsKey(name) || ListConstante.containsKey(name)){
										
										if(!(ListVars.containsKey(name) || ListConstante.containsKey(name))){
											 
											 ListErrors.add("Erreur: la variable du tableau utilisee n'est pas declaree!");
											 System.out.println("Erreur: la variable du tableau utilisee n'est pas declaree!");
										 }
										
									 ListIndiceTab.add(name);
									 
								}
								
								 else if(ListTableau.containsKey(name)){
									
									 ListErrors.add("Erreur: la variable du tableau est deja declaree!");
									 System.out.println("Erreur: la variable du tableau est deja declaree!");
								 }
								 
								  else{
									    ListTableau.put(name, TypeTableau);
								  }
									
								}
						 }
				}
		}

						 
		if(a.equals("methode") && !MainMeth.equals("main")){
			NON = "";
			IdentMet= name;
			ii = name;
			Signaturefct.clear();
			ListVarLocal.clear();
			ListCstLocal.clear();
			ListTableauLocal.clear();
			ListIndiceTabLocal.clear();
			ListcheckTap.clear();
			ListcheckTap1.clear();
			TypeVarLocal.clear();
			TypeVarEntete.clear();

			if(ListVarMeth.containsKey(name) && !TAB.equals("tab")){
			
				ListErrors.add("Erreur: la methode existe deja[methode]!");
				System.out.println("Erreur: la methode existe deja[methode]!");
			}
			else{
				ListVarMeth.put(name, TypeMeth);
				Typemeth = ListVarMeth.get(name);

			}
		}

		if(Affectation.equals("affectation")){

			for(int d = 0; d < Vnil; d++){
				if(a.equals("tab")){
					
				  if(TAB.equals("tab") && nbre.equals("nombre") && !MAIN.equals("Main") && identificateur.equals("IDENT") && (ADD.equals("addition") || SUB.equals("soustraction")
							|| DIV.equals("division") || MUL.equals("multiplication"))){
					  System.out.println("TTTT "+name);
					  
					if(TAB.equals("tab") && !(a.equals("affectation") && MAIN.equals("Main"))){
							  if(ListTableauLocal.containsKey(name) ){

								  	valTypeTab1 = (String) ListTableauLocal.get(name);
									ListcheckTap.add(valTypeTab1);
							    }
								else if(Signaturefct.containsKey(name)){
									
									String varAffTab2 = (String) Signaturefct.get(name);

									if(!(valTypeTab1.equals(varAffTab2))){
										ListErrors.add("Erreur: l'indice du tableau n'est pas compatible![methode]");
										System.out.println("Erreur: l'indice du tableau n'est pas compatible![methode]"+name);
									}
								}
								else if(ListVarLocal.containsKey(name)){
									varAffTab1 = (String) ListVarLocal.get(name);	

									if(!(valTypeTab1.equals(varAffTab1))){
										ListErrors.add("Erreur: l'indice du tableau n'est pas compatible![methode]");
										System.out.println("Erreur: l'indice du tableau n'est pas compatible![methode]"+name);
									}
								}
								
								else{
									
									System.out.println("Erreur: utilisation de tableau ou indice non declare![methode]"+name);
									ListErrors.add("Erreur: utilisation de tableau ou indice non declare![methode]");
								}
						identificateur = "";
						TAB = "";
				     
				  }
				}

					
			        else if(a.equals("affectation") && !MAIN.equals("Main") && nbre.equals("nombre") && TAB.equals("tab") 
			        	&& identificateur.equals("IDENT") || DIV.equals("division") || ADD.equals("addition") || SUB.equals("soustraction")
			        	|| MUL.equals("multiplication")){
			        	
			        	if(ListVarLocal.containsKey(name)){
			        	    TypeAffect = (String) ListVarLocal.get(name);
							ListcheckTap1.add(TypeAffect);
							affectApellE = name;
			        	}
			        	else{
			        		if(Signaturefct.containsKey(name)){
			        			TypeAffect1 = (String) Signaturefct.get(name);
								ListcheckTap2.add(TypeAffect1);
								
								for(int i = 0; i < ListcheckTap.size(); i++){
									
									if(!ListcheckTap2.isEmpty()){
										for(int j = 0; j < ListcheckTap2.size(); j++){
											if(identificateur.equals("IDENT")){

												String TypeTableau1 = ListcheckTap.get(i);
												String TypeValeurAff1 = ListcheckTap2.get(j);
												
												
												
												if(!TypeTableau1.equals(TypeValeurAff1)){
													ListErrors.add("Erreur: Type incompatible![methodeI]");
													System.out.println("Erreur: Type incompatible![methodeI]");
												}
												
												identificateur = "";
											}
										
										}
									}
								
								}
			        		}
			        	}
							
							
							for(int i = 0; i < ListcheckTap.size(); i++){
								
								if(!ListcheckTap1.isEmpty()){
									for(int j = 0; j < ListcheckTap1.size(); j++){
										if(identificateur.equals("IDENT")){

											String TypeTableau = ListcheckTap.get(i);
											String TypeValeurAff = ListcheckTap1.get(j);
											
											
											
											if(!TypeTableau.equals(TypeValeurAff)){
												ListErrors.add("Erreur: Type incompatible![methode]");
												System.out.println("Erreur: Type incompatible![methode]");
											}
											
											identificateur = "";
										}
									}
								}
							}
			        }
									
		else if(a.equals("appelE") || nbre.equals("nombre") && !MAIN.equals("Main") && !(ET.equals("et") || OU.equals("ou"))  && identificateur.equals("IDENT")){
					IdentAplE = name;
					
		}
		
	    else{ 
	    	break; 
	    }
	  }
	}
}
		
						 
		if(a.equals("entete")){

				for( int i = 0; i < Vide; i++){
					if(test.equals("entetee")){
						
							if(Signaturefct.containsKey(name)){
                                ListErrors.add("Erreur: argument de la methode deja declare");
								System.out.println("Erreur: argument de la methode deja declare");
						    } 
						 
							else{
								Signaturefct.put(name, TypeEntete);
								
								ENTETEMETHAPPel.add(IdentMet+TypeEntete);
								ENTETEMETHAPPel1.add(IdentMet+TypeEntete);
								ConcTypeNommeth = IdentMet+TypeEntete;
								EnTeTeMeThOdE.put(IdentMet, TypeEntete);
							}
							test = "";
							p = "";
						
					}
					else{
						break;			
					}
			}
		}
		
		
		if(VaRs.equals("vars") && METHODE.equals("methode")){
			if(a.equals("var")){		
				for( int z = 0; z < Vnil; z++){
					if(!MAIN.equals("Main")){
					  if(Vn.equals("var")){
						if(ListVarLocal.containsKey(name)){
							ListErrors.add("Erreur: variable de la methode existe deja!");
							System.out.println("Erreur: variable de la methode existe deja!");

						}
						else if(ListCstLocal.containsKey(name)){
							ListErrors.add("Erreur: variable de la methode existe deja comme constante!");
							System.out.println("Erreur: variable de la methode existe deja comme constante!");
						}

						else if(Signaturefct.containsKey(name)){
							ListErrors.add("Erreur: variable de la methode existe deja comme entete!");
							System.out.println("Erreur: variable de la methode existe deja comme entete!");
						}
						else{
							ListVarLocal.put(name, typeVar);
							String TypeVar = ListVarLocal.get(name);
							TypeVarLocal.add(TypeVar);
							typedeclmeth = ListVarLocal.get(name);
						}
				   }
					  else{
						  if(!(ListVarLocal.containsKey(name) || ListCstLocal.containsKey(name) || Signaturefct.containsKey(name))){
								System.out.println("Erreur: Variable indefinie!" +name);

	                	 }
	                	 else{
	                		 if(ListVarLocal.containsKey(name)){
	                			 tyPEvaraffectmeth = ListVarLocal.get(name);		
	                		 }
	                		 else if(ListCstLocal.containsKey(name)){
	                			 tyPEvaraffectmeth = ListCstLocal.get(name);		
	                		 }
	                		 else{
	                			 tyPEvaraffectmeth = Signaturefct.get(name);		
									
	                		 }
	                	 }	
					  }
					  if(!tyPEvaraffectmeth.isEmpty() && !typedeclmeth.isEmpty() ){
							 if(!tyPEvaraffectmeth.equals(typedeclmeth)){
								 System.out.println("Erreur: type de variable incompatible [locale]!"+tyPEvaraffect);
							 }
		              }
					  Vn = "";
					}
					else if(Signaturefct.containsKey(name)){
						String TypeEntete = (String) Signaturefct.get(name);
						TypeVarEntete.add(TypeEntete);


						for(int i = 0; i < TypeVarLocal.size();i++){

							if(!TypeVarEntete.isEmpty()){
								for(int j = 0; j<TypeVarEntete.size();j++){

									String A = TypeVarLocal.get(i);
									String B = TypeVarEntete.get(j);

									if(!(A.equals(B))){
										ListErrors.add("Erreur: type de la variable initialisee est incompatible[methode]!");
										System.out.println("Erreur: type de la variable initialisee est incompatible[methode]!");
									}

								}
							}

							else{
								ListErrors.add("Erreur: Le tableau utilise n'est pas declare!");
								System.out.println("Erreur: Le tableau utilise n'est pas declare!");
							}
						}
					}
					else{
						break;
					}
				}	
			}
			
			if(a.equals("cst") && !MainMeth.equals("main")){		

				for( int z = 0; z < Vnil; z++){
					if(VNil.equals("venil")){

						if(ListCstLocal.containsKey(name)){
							ListErrors.add("Erreur: Constante de la methode existe deja!");
							System.out.println("Erreur: Constante de la methode existe deja!");
						}
						else if (ListVarLocal.containsKey(name)){
							ListErrors.add("Erreur: Constante de la methode existe deja comme variable!");
							System.out.println("Erreur: Constante de la methode existe deja comme variable!");
						}

						else if(Signaturefct.containsKey(name)){
							ListErrors.add("Erreur: Constante de la methode existe deja comme entete!");
							System.out.println("Erreur: Constante de la methode existe deja comme entete!");
						}

						else{
							ListCstLocal.put(name, typeCst);
						}
						VNil = "";
					}
					else{
						break;
					}

				}
			}

			
			if(Table.equals("tableau")){

				for( int dd = 0; dd < Vnil; dd++){

					if((a.equals("tableau") && !MAIN.equals("main") && identificateur.equals("IDENT"))){

						if(ListVarLocal.containsKey(name) || ListCstLocal.containsKey(name) || Signaturefct.containsKey(name)){
							ListIndiceTabLocal.add(name); 

						}
						else if(ListTableauLocal.containsKey(name)){
							ListErrors.add("Erreur: la variable du tableau est deja declaree![methode]");
							System.out.println("Erreur: la variable du tableau est deja declaree![methode]");
						}

						else{
							ListTableauLocal.put(name, TypeTableau);
						}
						identificateur = "";
					}
					
					else if(Vars.equals("vars") && Table.equals("tableau") && !MAIN.equals("main") && (a.equals("division") && identificateur.equals("IDENT") || a.equals("multiplication") || a.equals("addition") || a.equals("soustraction") )){
						if(Vars.equals("vars") && (ListVarLocal.containsKey(name) || ListCstLocal.containsKey(name) || Signaturefct.containsKey(name))){
							ListIndiceTabLocal.add(name); 

						}
						else{
							System.out.println("Erreur: l'indice du tableau n'est pas declare! "+name);
							
						}
						identificateur = "";
					}

					else{
						break;
					}
				}
			}	
			else{
				
			}
		}

		if(MainMeth.equals("main")){

			if(Vars.equals("vars") && !Affectation.equals("affectation")){
			
			if(Vars.equals("vars")){
				
				if(a.equals("var")){
				  if(Vn.equals("var")){  
					if(ListvarMain.containsKey(name)){
						ListErrors.add("La variable existe deja dans la methode principale!");
						System.out.println("La variable existe deja dans la methode principale!");
					}
					else if(ListcstMain.containsKey(name)){
						ListErrors.add("La variable existe deja comme constante dans la methode principale!");
						System.out.println("La variable existe deja comme constante dans la methode principale!");

					}
					else{
						ListvarMain.put(name, typeVar);
						typedeclmain = ListvarMain.get(name);
					}
				}
				  else{

					  if(!(ListVars.containsKey(name) || ListConstante.containsKey(name) || ListvarMain.containsKey(name))){
							System.out.println("Erreur: Variable indefinie!" +name);

                	 }
                	 else{
                		 if(ListVars.containsKey(name)){
								tyPEvaraffectmain = ListVars.get(name);		
                		 }
                		 else if(ListConstante.containsKey(name)){
								tyPEvaraffectmain = ListConstante.get(name);		
                		 }
                		 else{
								tyPEvaraffectmain = ListvarMain.get(name);		
                		 }
                	 }					  
				  }
				  if(!tyPEvaraffectmain.isEmpty() && !typedeclmain.isEmpty() ){
						 if(!tyPEvaraffectmain.equals(typedeclmain)){
							 System.out.println("Erreur: type de variable incompatible [main]!"+tyPEvaraffect);
						 }
	              }
				  Vn = "";
				}
				if(a.equals("cst")){

					if(ListcstMain.containsKey(name)){
						ListErrors.add("La constante existe deja dans la methode principale!");
						System.out.println("La constante existe deja dans la methode principale!");
					}
					else if(ListvarMain.containsKey(name)){
						ListErrors.add("La constante existe deja comme variable dans la methode principale!");
						System.out.println("La constante existe deja comme variable dans la methode principale!");
					}
					else{
						ListcstMain.put(name, typeVar);
					}
				}
			}
				 if(a.equals("appelE") && !(ET.equals("et") || OU.equals("ou"))){
						
						NomMethode = name;

				 }
				 
				 if(a.equals("listexp") && !aplI.equals("appelI")){	
					 	IdentListExAplEVars = name;
						
						String typeExp = "";
						if(ListVars.containsKey(name)){
							typeExp = ListVars.get(name);
						}
						if(ListvarMain.containsKey(name)){
							typeExp = ListvarMain.get(name);
						}
						if(ListcstMain.containsKey(name)){
							typeExp = ListcstMain.get(name);
						}

						TypeMethMainexpAppelEVars.add(NomMethode+typeExp);
						IdentappelEMainVars = NomMethode+typeExp;
					}
			}

			if(Affectation.equals("affectation")){
				if(a.equals("tab")){

					if(TAB.equals("tab")){

						typetableau = (String) ListTableau.get(name);

						if(ListTableau.containsKey(name) ){

							ListTab.add(typetableau);

						}

						else if(ListvarMain.containsKey(name) || ListVars.containsKey(name)){

							if(ListVars.containsKey(name)){
								typeIndice = (String) ListVars.get(name);
								ListIndice.add(typeIndice);
								
								for(int i = 0; i < ListTab.size();i++){
									  
									typeIndice = (String) ListVars.get(name);	
									

									ListIndice.add(typeIndice);


										if(!ListIndice.isEmpty()){
											for(int jj = 0; jj < ListIndice.size();jj++){

												String A4 = ListTab.get(i);
												String B4 = ListIndice.get(jj);

												if(!A4.equals(B4)){

													ListErrors.add("Erreur: l'indice du tableau n'est pas compatible![main]");
													System.out.println("Erreur: l'indice du tableau n'est pas compatible![main]");
												}

											}
										}
								
								}
							}

							else if(ListvarMain.containsKey(name)){
								
									  String typeIndice2 = (String) ListvarMain.get(name);
									  ListIndice2.add(typeIndice2);
									  
									  
									  for(int di = 0; di < ListTab.size(); di++){
										  if(!ListIndice2.isEmpty()){
												for(int k = 0; k < ListIndice2.size(); k++){
												
													String A1 = ListTab.get(di);
													String B1 = ListIndice2.get(k);
													
													if(!(A1.equals(B1))){
														ListErrors.add("Erreur: l'indice du tableau n'est pas compatible![main]");
														System.out.println("Erreur: l'indice du tableau n'est pas compatible![main]");
													}
										
												}
											}
					
								      }
							}
							else{}

						
						TAB="";
				  }
				
				else if(a.equals("affectation") && identificateur.equals("IDENT")){

					if(ListVars.containsKey(name) || ListvarMain.containsKey(name)){

						if(ListvarMain.containsKey(name)){
							String Typeval1= ListvarMain.get(name);

							ListValAff.add(Typeval1);

						}
						else{
							String Typeval = ListVars.get(name);
							ListValAff.add(Typeval);
						}

						for(int i = 0; i < ListTab.size(); i++){

							if(!ListValAff.isEmpty()){
								for(int j = 0; j < ListValAff.size(); j++){

									String A = ListTab.get(i);
									String B = ListValAff.get(j);

									if(!A.equals(B)){
										ListErrors.add("Erreur: le type de la variable affectee est incompatible!");
										System.out.println("Erreur: le type de la variable affectee est incompatible! "+ A+" et "+B);
									}

								}
							}
						}

					}

				}
				else{}
			 }
			}
				if(a.equals("affectation") && !(a.equals("listexp") && TAB.equals("tab"))){

					IdentAfMainAplE = name;
				}


				if(a.equals("appelE") && !n.equals("methode") && identificateur.equals("IDENT")){
					
				if(aplE.equals("appelE") && identificateur.equals("IDENT") ){
					IdentMainAplE = name;
				}

				if(a.equals("listexp") && !aplI.equals("appelI") && identificateur.equals("IDENT")){

					if(ListvarMain.containsKey(name)){
						IdentListExAplE = ListvarMain.get(name);
					}
					if(ListVars.containsKey(name)){
						IdentListExAplE = ListVars.get(name);
					}
					
					AppelEMethMain.add(IdentMainAplE+IdentListExAplE);
					
					TypeIdentAppelE = IdentMainAplE+IdentListExAplE;
				}
				}
				
			}
				
			   
			   if(MainMeth.equals("main") && !(Affectation.equals("affectation") && (a.equals("appelE") || a.equals("appelI") || a.equals("listexp"))) && (Affectation.equals("affectation") && (ADD.equals("addition") || SUB.equals("soustraction") || DIV.equals("division") || MUL.equals("multiplication")))){
				   if(MainMeth.equals("main") && !a.equals("affectation") && ListvarMain.containsKey(name) || ListVars.containsKey(name) || ListcstMain.containsKey(name)){
				             
				             if(ListVars.containsKey(name)){
						    	 String binaryOp2 = ListVars.get(name);
						    	 
									if(!binaryOp2.equals("entier")){
										System.out.println("Erreur: le type de la variable n'est pas un entier[main1]!");
									}
						     }
				             else if(ListcstMain.equals(name)){
				            	 String binaryOp3 = ListVars.get(name);
									if(!binaryOp3.equals("entier")){
										System.out.println("Erreur: le type de la variable n'est pas un entier[main2]!");
									}
				             }
						     else{
								     String binaryOp2 = ListvarMain.get(name);
										if(!binaryOp2.equals("entier")){
											System.out.println("Erreur: le type de la variable n'est pas un entier[main3]!");
										}
						     }
				   }
				   
			   }
			   identificateur = "";
			 
	     }	
		
		 if( a.equals("egal") || a.equals("somme") || a.equals("superieur") || a.equals("addition") || a.equals("soustraction") || a.equals("division") || a.equals("multiplication") || a.equals("increment")|| a.equals("retour")){
			 if(!MainMeth.equals("main") && ListVarLocal.containsKey(name) || Signaturefct.containsKey(name)){	
			        
			    if(Signaturefct.containsKey(name)){
			    	
			    	String binOp = Signaturefct.get(name);
			    	
			    }
				else{}
			}
		}
		


		if(a.equals("somme") || a.equals("superieur") || a.equals("addition") || a.equals("soustraction") || a.equals("division") || a.equals("multiplication") || a.equals("increment")|| a.equals("retour")){
			if(!MainMeth.equals("main") && ListVarLocal.containsKey(name) || Signaturefct.containsKey(name)){	

				if(Signaturefct.containsKey(name)){

					String binOp = Signaturefct.get(name);


					if(!binOp.equals("entier")){

						System.out.println("Erreur: le type de la variable n'est pas un entier[methode]! ");
					}

			    }
			    else{
			    	
			         String binOp1 = ListVarLocal.get(name);
						if(!binOp1.equals("entier")){
							System.out.println("Erreur: le type de la variable n'est pas un entier[methode]!");
						}
			    }
			 }
			 
			if(MainMeth.equals("main") && ListvarMain.containsKey(name) || ListVars.containsKey(name)){
				     
				     if(ListVars.containsKey(name)){
				    	 String binaryOp = ListVars.get(name);
							if(!binaryOp.equals("entier")){
								System.out.println("Erreur: le type de la variable n'est pas un entier[main4]!");
							}
				     }
				     else{
						     String binaryOp1 = ListvarMain.get(name);
								if(!binaryOp1.equals("entier")){
									System.out.println("Erreur: le type de la variable n'est pas un entier[main5]!");
								}
				     }
				 
			 }
		
			 else{}
		 }
	
		
		if((a.equals("et") || a.equals("egal") || a.equals("ou")) && nbre.equals("nombre")){
			if(!MainMeth.equals("main") && ListVarLocal.containsKey(name) || Signaturefct.containsKey(name)){	

				if(Signaturefct.containsKey(name)){
					String logOp = Signaturefct.get(name);
					
					if(!(logOp.equals("booleen") || logOp.equals("entier"))){
						System.out.println("Erreur: le type de la variable n'est pas un booleen ni un entier[methode]!");
					}

			    }
			    else{
			         String logOp1 = ListVarLocal.get(name);
	
			         
						if(!(logOp1.equals("booleen") || logOp1.equals("entier"))){
							System.out.println("Erreur: le type de la variable n'est pas un booleen ni un entier[methode]!");
						}
			    }
			 }
			 else if(ListvarMain.containsKey(name) || ListVars.containsKey(name)){
				     
				     if(ListVars.containsKey(name)){
				    	 String logikOp = ListVars.get(name);
				    	 
							if(!(logikOp.equals("booleen") || logikOp.equals("entier"))){
								System.out.println("Erreur: le type de la variable n'est pas un booleen ni un entier[main]!");
							}
				     }
				     else{
						     String logikOp1 = ListvarMain.get(name);
								if(!(logikOp1.equals("booleen") || logikOp1.equals("entier"))){
									System.out.println("Erreur: le type de la variable n'est pas un booleen[main]!");
								}
				     } 
			 }
			 
			 else{}
        }
		 

				
		if(a.equals("retour") && !MAIN.equals("main")){
			if(ListVarLocal.containsKey(name)){
				
				String typretour = ListVarLocal.get(name);
	
				
				if(Typemeth.equals("rien")){
					System.out.println("Erreur: la methode void n'a pas de retour!");	
				}
				else if(!typretour.equals(Typemeth)){
					System.out.println("Erreur: le type de retour incompatible a la methode!");
	
				}
				else{}
			}
		}

		if(RETOUR.equals("retour") && !MainMeth.equals("main")){

			if(a.equals("somme") || a.equals("addition") || a.equals("soustraction") || a.equals("division") || a.equals("multiplication") || a.equals("increment")){

				String typeOp = "entier";
				if(Typemeth.equals("rien")){
					System.out.println("Erreur: la methode void n'a pas de retour[operateur binaire]!");	
				}
				else if(!typeOp.equals(Typemeth)){
					System.out.println("Erreur: le type de retour incompatible a la methode[operateur binaire]!");

				}
				else{}

			}
			else if(a.equals("et") || a.equals("superieur") || a.equals("egal") || a.equals("ou")){

				String typeOp = "booleen";
				if(Typemeth.equals("rien")){
					System.out.println("Erreur: la methode void n'a pas de retour[operateur logique]!");	
				}
				else if(!typeOp.equals(Typemeth)){
					System.out.println("Erreur: le type de retour incompatible a la methode[operateur logique]!");

				}
				else{}
			}
			else{}
		}

		if(NON.equals("non")){
			String Non;
			String typeident = "booleen";
			if(ListVarLocal.containsKey(name)){
				Non = ListVarLocal.get(name);

				if(!(VRAI.equals("vrai") || FAUX.equals("faux") || Non.equals(typeident))){
					System.out.println("Erreur: le type attendu est boolean [non]!");
				}
			}
			else if(ListVars.containsKey(name)){
				Non = ListVars.get(name);

				if(!(VRAI.equals("vrai") || FAUX.equals("faux") || Non.equals(typeident))){
					System.out.println("Erreur: le type attendu est boolean [non]!");
				}
			}
			else if(ListvarMain.containsKey(name)){
				Non = ListvarMain.get(name);

				if(!(VRAI.equals("vrai") || FAUX.equals("faux") || Non.equals(typeident))){
					System.out.println("Erreur: le type attendu est boolean [non]!");
				}
			}
			else if(ListConstante.containsKey(name)){
				Non = ListConstante.get(name);

				if(!(VRAI.equals("vrai") || FAUX.equals("faux") || Non.equals(typeident))){
					System.out.println("Erreur: le type attendu est boolean [non]!");
				}
			}
			else if(ListCstLocal.containsKey(name)){
				Non = ListCstLocal.get(name);

				if(!(VRAI.equals("vrai") || FAUX.equals("faux") || Non.equals(typeident))){
					System.out.println("Erreur: le type attendu est boolean [non]!");
				}
			}
			else{}
			NON="";
		}
		
		if(a.equals("appelI") && (ET.equals("et")|| OU.equals("ou")) && !SI.equals("si")){
			System.out.println("Erreur: Mauvais usage d'appel de la methode!");
		}
		
		if(a.equals("appelI") && !MainMeth.equals("main")){
			IdentMetListExp = name;
			
		}		
		
		if(a.equals("appelI") && MainMeth.equals("main")){
			if(ListVarMeth.containsKey(name)){
				
				
				typeApl = ListVarMeth.get(name);
				IdentMetListExpMain = name;
				
				
				if(!typeApl.equals("rien")){
					ListErrors.add("le type de la methode n'est pas void, veuillez l'affecter a une variable [main][APPEL I]");
					System.out.println("le type de la methode est "+ typeApl +", veuillez l'affecter a une variable [main][APPEL I]");
				}
			}
		}
		

		if(!ListCompteEntete.isEmpty() && nomEntete.equals("entete") && MainMeth.equals("main") && a.equals("appelI") && nbre.equals("nombre")){
			IdentMainAppelI = name;
			
		}

		if(a.equals("listexp")){
			String typexp = "";
			
			if(METHODE.equals("methode") && !MaIn.equals("main") && (aplI.equals("appelI") || aplE.equals("appelE") || nbre.equals("nombre"))){
				
				if(!(ListVarLocal.containsKey(name) || ListCstLocal.containsKey(name) || Signaturefct.containsKey(name))){
					System.out.println("Erreur: variable non declaree [methode]: "+name);
				}
				else{
					if(ListVarLocal.containsKey(name) || ListCstLocal.containsKey(name) || Signaturefct.containsKey(name)){
						if(ListVarLocal.containsKey(name)){
							typexp = ListVarLocal.get(name);
						}
						else if(ListCstLocal.containsKey(name)){
							typexp = ListCstLocal.get(name);
						}
						else{
							if(Signaturefct.containsKey(name)){	
							   typexp = Signaturefct.get(name);
							}
						}
						
						TypeMethListexp.add(IdentMetListExp+typexp);
					}
				}
			}
			
			if(MaIn.equals("main") && (aplI.equals("appelI") || aplE.equals("appelE") || nbre.equals("nombre"))){
				
				if(!(ListVars.containsKey(name) || ListConstante.containsKey(name) || ListvarMain.containsKey(name))){
					
					System.out.println("Erreur: variable non declaree[main]: "+name);
				}
				else{
					if(ListVars.containsKey(name) || ListvarMain.containsKey(name) || ListConstante.containsKey(name) || nbre.equals("nombre") || ListvarMain.containsKey(name)){
						
						if(ListVars.containsKey(name)){
							typexp = ListVars.get(name);
						}
						else if(ListConstante.containsKey(name)){
							typexp = ListConstante.get(name);
						}
						else{
							typexp = ListvarMain.get(name);
						}	
						
						TypeMethexpMain.add(IdentMainAppelI+typexp);
						
						IdentAplI = IdentMainAppelI+typexp;
					}
				}
			}
		}

		else{}
		 
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		
		 return null;	
  }
	





	//Methode ASTtableau
	public String visit(ASTtableau node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		String Typetab = node.jjtGetChild(0).toString();

		Table = "tableau";
		String checkTab = Check_Type(Typetab);
		VNil = "venil";

		TypeTableau = Typetab;

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTmoins
	public String visit(ASTmoins node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		String noeud = node.jjtGetChild(0).toString();

		if(!noeud.equals("nombre")){
			ListErrors.add("Erreur: la valeur attendu est un nombre!");
			System.out.println("Erreur: la valeur attendu est un nombre!");
		}

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}


	//Methode ASTdecls
	public String visit(ASTdecls node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		context = "declaration";


		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTvnil
	public String visit(ASTvnil node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		Vnil +=1;
		LExp = 0;
		Table = "";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTvars
	public String visit(ASTvars node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		Vars = "vars";
		VaRs = "vars";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTomega
	public String visit(ASTomega node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTmain
	public String visit(ASTmain node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		MainMeth = "main";
		MAIN = "Main";
		IdentFctMain = "main";
		MaIn = "main";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTinstrs
	public String visit(ASTinstrs node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTinil
	public String visit(ASTinil node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		Affectation = "";
		
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTaffectation
	public String visit(ASTaffectation node, Object data) throws InterpretationException {


		// TODO Auto-generated method stub

		VNil = "venil";
		Vars = "vars";
		Affectation = "affectation";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTsomme
	public String visit(ASTsomme node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		SOM = "somme";
		
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTincrement
	public String visit(ASTincrement node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTappelI
	public String visit(ASTappelI node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		appeli += 1;
		aplI = "appelI";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTretour
	public String visit(ASTretour node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		RETOUR = "retour";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTsi
	public String visit(ASTsi node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		SI = "si";

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTtantque
	public String visit(ASTtantque node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTlistexp
	public String visit(ASTlistexp node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		ListExp = "listexp";
		LExp += 1;
		leX += 1;
		//System.out.println("exnil "+leX);

		CC = "LISTEXP";
		lexp = String.valueOf(LExp);


		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTexnil
	public String visit(ASTexnil node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		Ex = "exnil";
		
		if((aplE.equals("appelE")  && ListExp.equals("listexp") && Ex.equals("exnil")) || (aplI.equals("appelI")  && nbre.equals("nombre") && ListExp.equals("listexp") && Ex.equals("exnil"))){
			valExp = String.valueOf(leX);
			
		}
		
		if(MainMeth.equals("main") && VaRs.equals("vars") && aplE.equals("appelE") && !(Vn.equals("var") 
			|| ASTEn.equals("enil") || Affectation.equals("affectation") || ET.equals("et") || OU.equals("ou"))){
			
			AppelEMethMainVars.put(NomMethode, valExp);
			
			 String ab = ListCompteEntete.get(NomMethode);
			 String ac = AppelEMethMainVars.get(NomMethode);
			 if(!(ListvarMain.containsKey(IdentListExAplEVars) || ListVars.containsKey(IdentListExAplEVars))){
					System.out.println("Erreur: variable non declaree [mainVars]: "+IdentListExAplEVars);
			 }
			
				 if(!ab.equals(ac)){
					 ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [mainVars]!");
					 System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [mainVars]");
					 System.out.println("Nombre d'argument de la methode "+ IdentMetListExp + " est " + ab);
				 }
			 
			 if(ListVarMeth.containsKey(NomMethode)){
				 
			 
			 for(int i = 0; i < TypeMethMainexpAppelEVars.size(); i++){
					
					if(TypeMethMainexpAppelEVars.contains(IdentappelEMainVars)){

							String typeList = TypeMethMainexpAppelEVars.get(i);
							String typentetee = ENTETEMETHAPPel.get(J);

							if(!typeList.equals(typentetee)){
								System.out.println("Erreur: type d'argument incompatible au type d'argument de la methode appelee [mainVars]" );
							}
					}
					J+=1;
				}
			 TypeMethMainexpAppelEVars.clear();
			 }
		}
		
		    leX = 0;
		    
		    if(aplI.equals("appelI") && !(MAIN.equals("Main") && ASTEn.equals("enil"))){
		    	
		    	ListExpEntete.put(IdentMetListExp, valExp);
		    	
					if(!ListExpEntete.isEmpty()){
								 String ab = ListCompteEntete.get(IdentMetListExp);
								 String ac = ListExpEntete.get(IdentMetListExp);
								
					
												 if(!ab.equals(ac)){
													 ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [methode]!");
													 System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [methode]");
													 System.out.println("Nombre d'argument de la methode "+ IdentMetListExp + " est " + ab);
													 ident = "IDENT";
												 }
					}
		    }



		if(aplE.equals("appelE") && !(MAIN.equals("Main") || VaRs.equals("vars") || Vn.equals("var") || ET.equals("et") || OU.equals("ou"))){
			AppelEMeth.put(IdentAplE, valExp);

			String TYPFONCTION = ListVarMeth.get(IdentAplE);
			System.out.println("maman "+IdentAplE);
			if(!(TYPFONCTION.equals("booleen") || TYPFONCTION.equals("entier"))){
				System.out.println("Erreur: le type de la methode attendu est boolean ou int!");
			}

			String typeVaraffecte = "";

			if(!(ListVarLocal.containsKey(affectApellE) || ListCstLocal.containsKey(affectApellE) || Signaturefct.containsKey(affectApellE))){
				System.out.println("Erreur: variable non declaree [methode]: "+affectApellE);
			}

			else{
				if(ListVarLocal.containsKey(affectApellE)){
					typeVaraffecte = ListVarLocal.get(affectApellE);
					if(!typeVaraffecte.equals(TYPFONCTION)){
						System.out.println("Erreur: type de la variable incompatible au type de la methode affectee [methode]: "+affectApellE);

					}
				}
				
				else if(ListCstLocal.containsKey(affectApellE)){
					typeVaraffecte = ListCstLocal.get(affectApellE);

					if(!typeVaraffecte.equals(TYPFONCTION)){
						System.out.println("Erreur: type de la variable incompatible au type de la methode affectee [methode]: "+affectApellE);
					}
				}
				else{
					typeVaraffecte = Signaturefct.get(affectApellE);
					if(!typeVaraffecte.equals(TYPFONCTION)){
						System.out.println("Erreur: type de la variable incompatible au type de la methode affectee [methode]: "+affectApellE);
					}
				}
			}
		}


		    if(IdentFctMain.equals("main") && !(NOD.equals("enil") && aplE.equals("appelE"))){
		    	
				ListExpEnteteMain.put(IdentMainAppelI, valExp);
				
				 if(!ListExpEnteteMain.isEmpty() && ListCompteEntete.containsKey(IdentMainAppelI)){
					 
					 ab1 = ListCompteEntete.get(IdentMainAppelI);
					 String ac1 = ListExpEnteteMain.get(IdentMainAppelI);
					 
						 if(!ab1.equals(ac1)){
							 ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [main]!");
							 ListErrors.add("Nombre d'argument de la methode "+ IdentMainAppelI + " est " + ab1);
							 System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [main]");
							 System.out.println("Nombre d'argument de la methode "+ IdentMainAppelI + " est " + ab1);
							 
						 }
			     }

			if(!AppelEMeth.isEmpty()){
				String ab2 = ListCompteEntete.get(IdentAplE);
				String ac2 = AppelEMeth.get(IdentAplE);


				if(!ab2.equals(ac2)){
					ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [methode]!");
					System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [methode]");
					System.out.println("Nombre d'argument de la methode "+ IdentMetListExp + " est " + ab2);

				}



				 else{
					 if(ListCompteEntete1.containsKey(IdentMainAppelI)){
						 String ab7 = ListCompteEntete1.get(IdentMainAppelI);
						 String ac7 = ListExpEnteteMain.get(IdentMainAppelI);
						 if(!ab7.equals(ac7)){
							 ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [main]!");
							 ListErrors.add("Nombre d'argument de la methode "+ IdentMainAppelI + " est " + ab2);
							 System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [main]");
							 System.out.println("Nombre d'argument de la methode "+ IdentMainAppelI + " est " + ab2);
							 
						 }
					 }
				 }
			}
	    }
		   
		
			if(ListVarMeth.containsKey(IdentMetListExp) && !(MainMeth.equals("main") && aplE.equals("appelE"))){
				
				for(int i = 0; i < TypeMethListexp.size(); i++){
						String typeList = TypeMethListexp.get(i);
						String typentetee = ENTETEMETHAPPel.get(i);
						
						if(!(typeList.equals(typentetee) || nbre.equals("nombre"))){
							System.out.println("Erreur: type d'argument incompatible au type d'argument de la methode appelee [methode]" );
						}
				}	

		}

		if(IdentFctMain.equals("main") && !aplE.equals("appelE") && !NOD.equals("enil") && (ListExp.equals("listexp") && nbre.equals("nombre"))){

			ListExpEnteteMain.put(IdentMainAppelI, valExp);

			if(!ListExpEnteteMain.isEmpty()){

				ab1 = ListCompteEntete.get(IdentMainAppelI);
				String ac1 = ListExpEnteteMain.get(IdentMainAppelI);
               
                
				if(!ab1.equals(ac1)){
					ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [main]!");
					ListErrors.add("Nombre d'argument de la methode "+ IdentMainAppelI + " est " + ab1);
					System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [main]");
					System.out.println("Nombre d'argument de la methode "+ IdentMainAppelI + " est " + ab1);

				}
			}
		}

		if(ListVarMeth.containsKey(IdentMetListExp) && !MainMeth.equals("main") && !aplE.equals("appelE")){

			for(int i = 0; i < TypeMethListexp.size(); i++){
				String typeList = TypeMethListexp.get(i);
				String typentetee = ENTETEMETHAPPel.get(i);

				if(!(typeList.equals(typentetee) || nbre.equals("nombre"))){
					System.out.println("Erreur: type d'argument incompatible au type d'argument de la methode appelee [methode]" );
				}

			}
		}
		
		if(ListVarMeth.containsKey(IdentMetListExpMain) && MainMeth.equals("main") && !aplE.equals("appelE")){

			for(int i = 0; i < TypeMethexpMain.size(); i++){

				if(TypeMethexpMain.contains(IdentAplI)){
					String typeList = TypeMethexpMain.get(i);
					String typentetee = ENTETEMETHAPPel.get(i);

					if(!typeList.equals(typentetee)){
						
						System.out.println("Erreur: type d'argument incompatible au type d'argument de la methode appelee [main]" );

					}
				}
				I+=1;
			}
		}
			
			
			if(ListVarMeth.containsKey(IdentMetListExpMain) && MainMeth.equals("main") && !VaRs.equals("vars")){
				
				for(int i = 0; i < TypeMethexpMain.size(); i++){
					
					if(TypeMethexpMain.contains(IdentAplI)){
							String typeList = TypeMethexpMain.get(i);
					 	   
							String typentetee = ENTETEMETHAPPel.get(I);
							
							if(!typeList.equals(typentetee)){
								System.out.println("Erreur: type d'argument incompatible au type d'argument de la methode appelee [main]" );
							}
					}

			TypeMethexpMain.clear();
		     }
		}
			
		if(IdentFctMain.equals("main") && aplE.equals("appelE") && Affectation.equals("affectation") && !(ET.equals("et") || VaRs.equals("vars") || aplI.equals("appelI"))){
	

			AppelEMeth.put(IdentMainAplE, valExp);

			String TYPFONCTION2 = ListVarMeth.get(IdentMainAplE);
			

			if(!(TYPFONCTION2.equals("booleen") || TYPFONCTION2.equals("entier"))){
				System.out.println("Erreur: le type de la methode affecte attendu est boolean ou int [main]!");
			}

			String typeVaraffecte2 = "";

			if(!(ListvarMain.containsKey(IdentAfMainAplE) || Signaturefct.containsKey(IdentAfMainAplE))){
				System.out.println("Erreur: variable non declaree [main]: "+IdentAfMainAplE);
			}

			else{
				if(ListVarLocal.containsKey(IdentAfMainAplE)){
					typeVaraffecte2 = ListVarLocal.get(IdentAfMainAplE);
					if(!typeVaraffecte2.equals(TYPFONCTION2)){
						System.out.println("Erreur: type de la variable incompatible au type de la methode affectee [methode]: "+affectApellE);

					}

				}
			}
		}

			if(IdentFctMain.equals("main") && Affectation.equals("affectation") && aplE.equals("appelE") && !((VaRs.equals("vars") 
					|| Vn.equals("var") || aplI.equals("appelI") || ET.equals("et") || OU.equals("ou")))){
				
		    	AppelEMeth.put(IdentMainAplE, valExp);
		    	String typeVaraffecte3 = "";
					String TYPFONCTION3 = ListVarMeth.get(IdentMainAplE);
					
					      if(!(TYPFONCTION3.equals("booleen") || TYPFONCTION3.equals("entier"))){
					    	  System.out.println("Erreur: le type de la methode affecte attendu est boolean ou int [main]!");
					      }
					     
					    else if(!(ListvarMain.containsKey(IdentAfMainAplE) || Signaturefct.containsKey(IdentAfMainAplE))){
							System.out.println("Erreur: variable non declaree [main]: "+IdentAfMainAplE);
						}
						
						else{
							if(ListVarLocal.containsKey(IdentAfMainAplE)){
								typeVaraffecte3 = ListVarLocal.get(IdentAfMainAplE);
								if(!typeVaraffecte3.equals(TYPFONCTION3)){
									System.out.println("Erreur: type de la variable incompatible au type de la methode affectee [main]: "+affectApellE);
								}
							}
						}
						
								
			if(!AppelEMeth.isEmpty()){
				String ab3 = ListCompteEntete.get(IdentMainAplE);
				String ac3 = AppelEMeth.get(IdentMainAplE);

				if(!ab3.equals(ac3)){
					ListErrors.add("Erreur : Veuillez ajouter les arguments requis de la fonction [main]!");
					System.out.println("Erreur : Veuillez ajouter les arguments requis de la fonction [main]");
					System.out.println("Nombre d'argument de la methode "+ IdentMetListExp + " est " + ab3);

				}

							 if(ListVarMeth.containsKey(IdentMainAplE) && !ENTETEMETHAPPel1.isEmpty()  || AppelEMethMain.contains(TypeIdentAppelE) && ENTETEMETHAPPel1.contains(TypeIdentAppelE)){
								 
								 
								    for(int n = 0; n < AppelEMethMain.size(); n++){

												String typeList = AppelEMethMain.get(n);
												String typentetee = "";
												
												   if(AppelEMethMain.size() == ENTETEMETHAPPel1.size()){
														typentetee = ENTETEMETHAPPel1.get(n);
												   }
												   else{
													   typentetee = ENTETEMETHAPPel1.get(n+1);
												   }
												
												if(!typeList.equals(typentetee)){
													System.out.println("Erreur: type d'argument incompatible au type d'argument de la methode appelee [mainAppelE]" );
												}
												
								    
									}

							 }
								
			}

		}

		for(int f = 0; f < node.jjtGetNumChildren(); f++){
			node.jjtGetChild(f).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTnon
	public String visit(ASTnon node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		NON = "non";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTet
	public String visit(ASTet node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		ET = "et";
		



		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTou
	public String visit(ASTou node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		OU = "ou";
		


		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTegal
	public String visit(ASTegal node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTsuperieur
	public String visit(ASTsuperieur node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTaddition
	public String visit(ASTaddition node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		ADD = "addition";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTsoustraction
	public String visit(ASTsoustraction node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		SUB = "soustraction";

		for(int i = 0; i < node.jjtGetNumChildren(); i++){

			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTmultiplication
	public String visit(ASTmultiplication node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		MUL = "multiplication";
			
		for(int i = 0; i < node.jjtGetNumChildren(); i++){

			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTdivision
	public String visit(ASTdivision node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		DIV = "division";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTtab
	public String visit(ASTtab node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		TAB="tab";
		Tableau = "tableau";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}

		return null;

	}

	//Methode ASTappelE
	public String visit(ASTappelE node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		aplE = "appelE";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTvrai
	public String visit(ASTvrai node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		VRAI = "vrai";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTfaux
	public String visit(ASTfaux node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		FAUX = "faux";

		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTrien
	public String visit(ASTrien node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTbooleen
	public String visit(ASTbooleen node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTentier
	public String visit(ASTentier node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTnombre
	public String visit(ASTnombre node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub

		nbre = "nombre";
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTidentAffich
	public String visit(ASTidentAffich node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	//Methode ASTInput
	public String visit(ASTInput node, Object data) throws InterpretationException {
		// TODO Auto-generated method stub
		for(int i = 0; i < node.jjtGetNumChildren(); i++){
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}


	//Methode de check_Type du type defini
	public String Check_Type(String type){	
		String m = "";
		if(!type.equals("entier")){
			if(!(type.equals("booleen"))){

				if(!type.equals("rien")){
					m = "inexistant";
				}
				else{
					m = "rien";
				}
			}
			else{
				m = "boolean";
			}
		}
		else{
			m = "entier";
		}
		return m;
	}

}
