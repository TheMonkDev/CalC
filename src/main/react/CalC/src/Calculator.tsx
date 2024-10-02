import Body from "./KeyBoard";
import Display from "./Display";

function Calculator() {
  return (
    <div className="center w-[400px] h-[650px] rounded-lg bg-black flex flex-col">
      <Display />
      <Body />
    </div>
  );
}

export default Calculator;
