// Show editMode section
function showEditDetails() {
	// Variables
	var editBlock = document.getElementById("siteDetails__editMode");
	var displayBlock = document.getElementById("siteDetails__displayMode");
	
	// Toggle edit mode with edit icon 
	if(editBlock.style.display === "none") {
		editBlock.style.display = "";
		displayBlock.style.display = "none";
	} else {
		editBlock.style.display = "none";
		displayBlock.style.display = "";
	}
}


/*
 * Add new elements to the site
 */
function addASector() {	
	// Variables
	var sectorsList = document.getElementById("editMode__sectors");
	
	// New sector name
	var newSectorLabel = document.createElement("label");
	newSectorLabel.htmlFor = "sector";
	newSectorLabel.innerHTML = "Nouveau secteur:";
	var newSectorInput = document.createElement("input");
	newSectorInput.type = "text";
	newSectorInput.name = "sector";
	newSectorInput.placeholder = "Nom du nouveau secteur...";
	newSectorInput.maxLength = "45";
	
	sectorsList.appendChild(newSectorLabel);
	sectorsList.appendChild(newSectorInput);
}


function addARoute() {
	// Variables
	var routesList = document.getElementById("editMode__routes");
	var routeQuotationSelect = document.getElementById("routeQuotationSelect");	
	var routeSectorSelect = document.getElementById("routeSectorSelect");
	
	
	// New route name
	var newRouteLabel = document.createElement("label");
	newRouteLabel.htmlFor = "route";
	newRouteLabel.innerHTML = "Nouvelle route:";
	var newRouteInput = document.createElement("input");
	newRouteInput.type = "text";
	newRouteInput.name = "route";
	newRouteInput.placeholder = "Nom de la nouvelle route...";
	newRouteInput.maxLength = "45";
	
	// Quotation list
	var newRouteQuotationSelect = routeQuotationSelect.cloneNode(true);
	newRouteQuotationSelect.setAttribute("name", "routeQuotation");
	newRouteQuotationSelect.disabled = false;
	newRouteQuotationSelect.style.display = "";
	
	// Route list
	var newRouteSectorSelect = routeSectorSelect.cloneNode(true);
	newRouteSectorSelect.setAttribute("name", "routeSector");
	newRouteSectorSelect.disabled = false;
	newRouteSectorSelect.style.display = "";
	
	routesList.appendChild(newRouteLabel);
	routesList.appendChild(newRouteInput);
	routesList.appendChild(newRouteQuotationSelect);
	routesList.appendChild(newRouteSectorSelect);
}


function addALength() {
	var lengthsList = document.getElementById("editMode__lengths");
	var lengthQuotationSelect = document.getElementById("lengthQuotationSelect");	
	var lengthRouteSelect = document.getElementById("lengthRouteSelect");
	
	
	// New length name
	var newLengthLabel = document.createElement("label");
	newLengthLabel.htmlFor = "length";
	newLengthLabel.innerHTML = "Nouvelle longueur:";
	var newLengthInput = document.createElement("input");
	newLengthInput.type = "text";
	newLengthInput.name = "length";
	newLengthInput.placeholder = "Nom de la nouvelle longueur...";
	newLengthInput.maxLength = "45";

	// Quotation list
	var newLengthQuotationSelect = lengthQuotationSelect.cloneNode(true);
	newLengthQuotationSelect.setAttribute("name", "lengthQuotation");
	newLengthQuotationSelect.disabled = false;
	newLengthQuotationSelect.style.display = "";
	
	// Route list
	var newLengthRouteSelect = lengthRouteSelect.cloneNode(true);
	newLengthRouteSelect.setAttribute("name", "lengthRoute");
	newLengthRouteSelect.disabled = false;
	newLengthRouteSelect.style.display = "";
	
	lengthsList.appendChild(newLengthLabel);
	lengthsList.appendChild(newLengthInput);
	lengthsList.appendChild(newLengthQuotationSelect);
	lengthsList.appendChild(newLengthRouteSelect);
}