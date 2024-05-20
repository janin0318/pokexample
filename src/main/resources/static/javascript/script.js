document.addEventListener('DOMContentLoaded', (event) => {
  const modal = document.getElementById('modal');
  const flavorTexts = modal.getElementsByClassName('flavor-text');
  const span = document.getElementsByClassName('close')[0];

  document.querySelectorAll('.modal-button').forEach(button => {
    button.addEventListener('click', () => {
      const flavorKey = button.getAttribute('data-flavor');

      // Hide all flavor texts and replace '\n' with '<br>'
      for (let i = 0; i < flavorTexts.length; i++) {
        flavorTexts[i].style.display = 'none';
      }

      // Show the clicked flavor text
      document.getElementById(flavorKey).style.display = 'block';
      modal.style.display = 'block';
    });
  });

  span.onclick = function() {
    modal.style.display = 'none';
  };

  window.onclick = function(event) {
    if (event.target === modal) {
      modal.style.display = 'none';
    }
  };
});
