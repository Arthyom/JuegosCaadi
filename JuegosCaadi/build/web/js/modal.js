/* Codigo JavaScript para abrir un modal y
 * poder cerrarlo con el span o dando clic fuera del modal
*/

function openInsert(){
    var modal = document.getElementById("modalInsert");
    
    modal.style.display = "block";
};

function openModify(){
    var modal = document.getElementById("modalModify");
    
    modal.style.display = "block";
};

function openDelete(){
    var modal = document.getElementById("modalDelete");
    
    modal.style.display = "block";
};

function closeSpan1(){
    var modal = document.getElementById("modalInsert");
    modal.style.display = "none";
}

function closeSpan2(){
    var modal = document.getElementById("modalModify");
    modal.style.display = "none";
}

function closeSpan3(){
    var modal = document.getElementById("modalDelete");
    modal.style.display = "none";
}

window.onclick = function(event) {
    var modal = document.getElementById("modalInsert");
    var modal2 = document.getElementById("modalModify");
    var modal3 = document.getElementById("modalDelete");
    
    if (event.target === modal || event.target === modal2 || event.target === modal3) {
        modal.style.display = "none";
        modal2.style.display = "none";
        modal3.style.display = "none";
    }
};

function show(){
    var objeto = document.getElementsByClassName("num");
    
    alert(objeto.toString());
};

function modify(num){
    var id = document.getElementById("id_"+num).getAttribute("value");
    var name = document.getElementById("name_"+num).getAttribute("value");
    var lenguage = document.getElementById("lenguage_"+num).getAttribute("value");
    var skills = document.getElementById("skills_"+num).getAttribute("value");
    var availableGame = document.getElementById("availableGame_"+num).getAttribute("value");
    var gamersNum = document.getElementById("gamersNum_"+num).getAttribute("value");
    var timeGame = document.getElementById("timeGame_"+num).getAttribute("value");
    var vocabularyGame = document.getElementById("vocabularyGame_"+num).getAttribute("value");
    var descriptionGame = document.getElementById("descriptionGame_"+num).getAttribute("value");
    var instructionGame = document.getElementById("instructionsGame_"+num).getAttribute("value");

    document.getElementById("ID").setAttribute("value",id);
    document.getElementById("NAME").setAttribute("value",name);
    document.getElementById("ABLE").setAttribute("value",availableGame);
    document.getElementById("SKILLS").setAttribute("value",skills);
    document.getElementById("LENGUAGE").setAttribute("value",lenguage);
    document.getElementById("NUMPART").setAttribute("value",gamersNum);
    document.getElementById("TIME").setAttribute("value",timeGame);
    document.getElementById("VOCABULARY").setAttribute("value",vocabularyGame);
    document.getElementById("INSTRUCTIONS").setAttribute("value",instructionGame);
    document.getElementById("DESCRIPTION").setAttribute("value",descriptionGame);
    
    openModify();
//    alert("id = "+ id +"\n name = "+ name +"\n lenguage = "+ lenguage +"\n skills = "+ skills +"\n availableGame = "+ availableGame +"\n gamersNum = "+ gamersNum +"\n timeGame = "+ timeGame +"\n vocabularyGame = "+ vocabularyGame +"\n descriptionGame = "+ descriptionGame +"\n instructionGame = "+ instructionGame);
};


/*getAttribute("value")*/
