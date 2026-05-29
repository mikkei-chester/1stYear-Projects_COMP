//HOME PAGE SCRIPTS
// Navbar scroll shadow --> shared with all pages accross the website
  window.addEventListener('scroll', () => {
    document.getElementById('mainNav').classList.toggle('scrolled', window.scrollY > 20);
  }, { passive: true });


//FAQ TOGGLE
// Category pill active toggle
    document.querySelectorAll('.cat-pill').forEach(btn => {
        btn.addEventListener('click', () => {
            document.querySelectorAll('.cat-pill').forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
        });
    });

