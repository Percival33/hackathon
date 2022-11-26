const startBtn = document.getElementById("start-btn");
const form = document.getElementById("form");
const parap = document.getElementsByTagName("p")[0];

const API_ENDPOINT = "";

let text = fetch("https://dog.ceo/api/breeds/image/random")
  .then((response) => response.json())
  .then((response) => {
    return response.message + " " + response.status;
  });

async function createForm(res) {
  if (res.question === null) return "";

  function getAnswers(res) {
    if (res.answers.length == 1) {
      return `<label for="question">${res.answers[0]}</label><br /><input type="radio" id="question"/><br />`;
    }
    let ans = "";
    for (i = 0; i < res.answers.length; i++) {
      ans += `<label for="question${i}">${res.answers[i]}</label><br /><input type="checkbox" id="question${i}"/><br />`;
    }
    return ans;
  }

  let form = `<form id="form" action="${API_ENDPOINT}" method="POST">
      <div>
        ${res.question}
      </div>
      ${getAnswers(res)}
      <button type="submit">Wyslij</button>
    </form>`;

  return form;
}

startBtn.addEventListener("click", async () => {
  console.log("dupa");
  parap.innerHTML = await text;
  form.innerHTML = await createForm({
    question: null,
    answers: ["aa", "cc"],
  });
});
