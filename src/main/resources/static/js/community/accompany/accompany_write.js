$(document).ready(function(){


    let choiceRegion = document.getElementById("region").value;
    let editRegion = document.querySelectorAll(".C-nav-btn")

    console.log(choiceRegion)
    console.log(editRegion.length);

    for (let i = 0; i < editRegion.length; i++){
        let editRegionValue = editRegion[i].innerText;
        console.log(editRegionValue)
        if (choiceRegion === editRegionValue) {
            editRegion[i].style.backgroundColor = "blue";
        }


    }

});



