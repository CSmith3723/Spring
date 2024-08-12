document.getElementById('calculate').addEventListener('click', async () => {

    // Get the screen or desired element to capture
    const captureElement = document.getElementById('map'); // Change this to your target element

    // Create a canvas and draw the region
    const canvas = document.getElementById('mapOutput');
    const context = canvas.getContext('2d');
    const width = captureElement.offsetWidth;
    const height = captureElement.offsetHeight;
    canvas.width = width;
    canvas.height = height;

    // Draw the region
    context.drawImage(captureElement, 0, 0, width, height);

    // Convert to data URL
    const dataURL = canvas.toDataURL('image/png');

    // Display the image (for debugging)
    document.getElementById('capturedMap').src = dataURL;

    // Send to the server
    fetch('/upload-image', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ image: dataURL })
    })
        .then(response => response.text())
        .then(result => {
            console.log(result); // Handle server response
        });
});