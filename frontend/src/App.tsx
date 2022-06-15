import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  const [data, setData] = useState<any>({});

  const options = {
    method: "GET",
    headers: {
      "X-RapidAPI-Key": "4115cbca79mshb98c674da0cbc1dp114d16jsnfe28b20a25e2",
      "X-RapidAPI-Host": "api-baseball.p.rapidapi.com",
    },
  };

  useEffect(() => {
    const url =
      "https://api-baseball.p.rapidapi.com/standings?league=1&season=2020";

    const fetchData = async () => {
      try {
        const response = await fetch(url, options);
        const json = await response.json();
        setData(json);
      } catch (error) {
        console.log("error", error);
      }
    };

    fetchData();
  }, []);

  let NL: any;
  let AL: any;

  if (data) {
    NL = data.response[0];
    AL = data.response[1];
  }

  NL.forEach((team) => {
    console.log(team.team.name);
  });
  // console.log(NL);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
