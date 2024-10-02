import Key from "./Key";

const numKeys = [
  "1",
  "2",
  "3",
  "+",
  "4",
  "5",
  "6",
  "-",
  "7",
  "8",
  "9",
  "*",
  "0",
  ".",
  "=",
  "/"
];
const extraKeys = ["Del", "C", "(", ")", "^"];

function KeyBoard() {
  return (
    <div className="flex flex-col items-center w-[97%] mx-auto mb-2 h-[calc(100%-150px)] bg-black text-white">
      <div className="w-[97%] mb-1 flex justify-between">
        {extraKeys.map((key, idx) => (
          <div className="m-1 w-16 h-10 bg-gray-900">
            <Key key={idx} keyValue={key} />
          </div>
        ))}
      </div>
      <div className="w-[99%] flex flex-row flex-wrap justify-center">
        {numKeys.map((key, idx) => (
          <div className="m-2 h-24 w-20 bg-gray-900">
            <Key key={idx} keyValue={key} />
          </div>
        ))}
      </div>
    </div>
  );
}

export default KeyBoard;
