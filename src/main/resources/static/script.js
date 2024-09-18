document.addEventListener('DOMContentLoaded', function () {
  // Verifica a URL da página para aplicar as ações corretas
  const currentPage = window.location.pathname;

  if (currentPage.includes('index.html')) {
      // Código para lidar com o formulário na página index.html
      const form = document.querySelector('form');

      form.addEventListener('submit', function (event) {
          event.preventDefault(); // Impede o envio padrão do formulário

          //pega os dados do form
          const formData = {
              name: document.getElementById('name').value,
              email: document.getElementById('email').value,
              checkin: document.getElementById('checkin').value,
              checkout: document.getElementById('checkout').value,
              notes: document.getElementById('notes').value,
              adults: parseInt(document.getElementById('adults').value, 10),
              children: parseInt(document.getElementById('children').value, 10)
          };

          //envia os dados para o json server
          fetch('http://localhost:3000/reservas', {
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json'
              },
              body: JSON.stringify(formData)
          })
          .then(response => response.json())
          .then(data => {
              console.log('Reserva adicionada com sucesso:', data);
              form.reset(); 

          
              alert('Reserva realizada com sucesso!');

              //direciona para a pagina de reservas
              window.location.href = 'reservas.html';
          })
          .catch((error) => {
              console.error('Erro ao adicionar reserva:', error);
              alert('Ocorreu um erro ao realizar a reserva. Tente novamente.');
          });
      });

  } else if (currentPage.includes('reservas.html')) {
      //exibe os dados na  reservas.html
      const tableBody = document.getElementById('reservations-table-body');

      function updateTable() {
          fetch('http://localhost:3000/reservas')
            .then(response => response.json())
            .then(data => {
              tableBody.innerHTML = ''; //limpa a tabela antes de atualizar

              data.forEach(reservation => {
                const row = document.createElement('tr');
                row.innerHTML = `
                  <td>${reservation.name}</td>
                  <td>${reservation.email}</td>
                  <td>${reservation.checkin}</td>
                  <td>${reservation.checkout}</td>
                  <td>${reservation.notes}</td>
                  <td>${reservation.adults}</td>
                  <td>${reservation.children}</td>
                `;
                tableBody.appendChild(row);
              });
            })
            .catch((error) => {
              console.error('Erro ao atualizar a tabela:', error);
            });
      }

      
      updateTable(); //inicia a tabela com os dados atualizados
  }
});