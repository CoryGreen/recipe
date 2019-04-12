"use strict";

function getAllRecipes() {
    let requestURL = 'http://localhost:8080/recipe/api/recipe/getAllRecipes';
    let request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.responseType = 'json'
    request.send();

    request.onload = function () {
        let recipes = request.response;
        document.getElementById("output").innerHTML = JSON.stringify(recipes);
    }
}