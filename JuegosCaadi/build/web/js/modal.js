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
    var id = document.getElementById("id_"+num).value;
    var name = document.getElementById("name_"+num).value;
    var lenguage = document.getElementById("lenguage_"+num).value;
    var skills = document.getElementById("skills_"+num).value;
    var availableGame = document.getElementById("availableGame_"+num).value;
    var gamersNum = document.getElementById("gamersNum_"+num).value;
    var timeGame = document.getElementById("timeGame_"+num).value;
    var vocabularyGame = document.getElementById("vocabularyGame_"+num).value;
    var descriptionGame = document.getElementById("descriptionGame_"+num).value;
    var instructionGame = document.getElementById("instructionsGame_"+num).value;
    var clase = document.getElementById("clase_"+num).value;
    var exist = document.getElementById("existencia_"+num).value;
    var adicional = document.getElementById("adicional_"+num).value;

    document.getElementById("ID").value = id;
    document.getElementById("NAME").value = name;
    document.getElementById("ABLE").value = availableGame;
    document.getElementById("SKILLS").value = skills;
    document.getElementById("LENGUAGE").value = lenguage;
    document.getElementById("NUMPART").value = gamersNum;
    document.getElementById("TIME").value = timeGame;
    document.getElementById("VOCABULARY").value = vocabularyGame;
    document.getElementById("INSTRUCTIONS").value = descriptionGame;
    document.getElementById("DESCRIPTION").value = instructionGame;
    document.getElementById("CLASE").value = clase;
    document.getElementById("EXIST").value = exist;
    document.getElementById("MATERIAL").value = adicional;
    
    openModify();
//    alert("id = "+ id +"\n name = "+ name +"\n lenguage = "+ lenguage +"\n skills = "+ skills +"\n availableGame = "+ availableGame +"\n gamersNum = "+ gamersNum +"\n timeGame = "+ timeGame +"\n vocabularyGame = "+ vocabularyGame +"\n descriptionGame = "+ descriptionGame +"\n instructionGame = "+ instructionGame);
};

function Delete(num){
    var id = document.getElementById("id_"+num).value;
    var name = document.getElementById("name_"+num).value;

    document.getElementById("IdMaterialBorrar").value = id;
    document.getElementById("deleteID").value = name;

    openDelete();
};

