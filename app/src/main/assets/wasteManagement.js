// wasteManagement.js
// JavaScript code to dynamically load and render H5P content

// Function to create and append iframe element
function loadH5PContent() {
    var h5pContentUrl = 'file:///assets/wasteManagement.html'; // File path to H5P content file
    var iframe = document.createElement('iframe');
    iframe.src = h5pContentUrl;
    iframe.width = '100%';
    iframe.height = '100%';
    iframe.frameBorder = '0';
    iframe.allowFullscreen = true;
    document.body.appendChild(iframe);
}

// Call the function to load H5P content
loadH5PContent();
