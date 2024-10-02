import { useState } from "react";
import KeyBoard from "./KeyBoard";
import Display from "./Display";
import useSubmit from "./submit.hook";

function Calculator() {

  const [expression, setExpression] = useState("");
  const {loading, onSubmit} = useSubmit();

  const onKeyPress = async (key: string) => {
    switch(key) {
      case "Del":
        setExpression(prev => prev.slice(0, prev.length - 1))
        break;
      case "C":
        setExpression("");
        break;
      case "=":
        setExpression(await onSubmit(expression));
        break;
      default:
        setExpression(prev => prev + key);
    }
  }

  return (
    <div className="center w-[400px] h-[650px] rounded-lg bg-black flex flex-col">
      <Display displayText={expression} isLoading={loading}/>
      <KeyBoard onKeyPress={onKeyPress}/>
    </div>
  );
}

export default Calculator;
