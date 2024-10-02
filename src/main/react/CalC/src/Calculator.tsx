import { useState } from "react";
import KeyBoard from "./KeyBoard";
import Display from "./Display";

function Calculator() {

  const [expression, setExpression] = useState("");

  const onKeyPress = (key: string) => {
    switch(key) {
      case "Del":
        setExpression(prev => prev.slice(0, prev.length - 1))
        break;
      case "C":
        setExpression("");
        break;
      case "=":
        break;
      default:
        setExpression(prev => prev + key);
    }
  }

  return (
    <div className="center w-[400px] h-[650px] rounded-lg bg-black flex flex-col">
      <Display displayText={expression} />
      <KeyBoard onKeyPress={onKeyPress}/>
    </div>
  );
}

export default Calculator;
