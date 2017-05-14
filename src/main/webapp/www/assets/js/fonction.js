function ajouterLigne()
{
    var tableau = document.getElementById("tableau");
    var ligne = tableau.insertRow(-1);//on a ajouté une ligne
    var colonne1 = ligne.insertCell(0);//on a une ajouté une cellule
    colonne1.innerHTML += document.getElementById("titre").value;//on y met le contenu de titre
    var colonne2 = ligne.insertCell(1);//on ajoute la seconde cellule
    colonne2.innerHTML += document.getElementById("titre").value;
    var colonne3 = ligne.insertCell(2);
    colonne3.innerHTML += document.getElementById("titre").value
    var colonne4 = ligne.insertCell(3);
    colonne4.innerHTML += document.getElementById("titre").value
    var colonne5 = ligne.insertCell(4);
    colonne5.innerHTML += document.getElementById("titre").value
    var colonne6 = ligne.insertCell(5);
    colonne6.innerHTML += document.getElementById("titre").value
}
function SuppimerDernierLigne()
{
    tableau.deleteRow(-1);
}