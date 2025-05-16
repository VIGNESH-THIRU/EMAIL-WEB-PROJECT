function sendEmail() {
  const to = document.getElementById('to').value;
  const subject = document.getElementById('subject').value;
  const body = document.getElementById('body').value;

  const statusMessage = document.getElementById('statusMessage');
  statusMessage.textContent = "Sending...";

  fetch('http://localhost:8080/api/email/send', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ to, subject, body })
  })
  .then(response => response.text())
  .then(data => {
    statusMessage.textContent = data;
  })
  .catch(error => {
    statusMessage.textContent = "Failed to send email: " + error;
  });
}
