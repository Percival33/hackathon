const startBtn = document.getElementById("start-btn");
const form = document.getElementById("form");
const parap = document.getElementsByTagName("p")[0];

let text = fetch("https://dog.ceo/api/breeds/image/random")
  .then((response) => response.json())
  .then((response) => {
    return response.message + " " + response.status;
  });

startBtn.addEventListener("click", async () => {
  console.log("dupa");
  parap.innerHTML = await text;
});
