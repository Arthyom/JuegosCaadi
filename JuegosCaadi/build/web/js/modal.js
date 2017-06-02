/* Codigo JavaScript para abrir el modal y poder solicitar un juego de la lista mostrada.
*/

var modal = document.getElementById("modalInsert");

window.onload = function openInsert(){
    modal.style.display = "block";
};

window.onload = function closeSpanInsert(){
    modal.style.display = "none";
};

window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
};
