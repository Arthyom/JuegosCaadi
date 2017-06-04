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
