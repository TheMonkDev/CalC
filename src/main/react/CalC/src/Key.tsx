interface KeyProps {
  keyValue: string;
  onKeyPress: (key: string) => void;
}

function Key({ keyValue, onKeyPress }: KeyProps) {
  return (
    <div
      onClick={() => onKeyPress(keyValue)}
      className="relative h-full w-full cursor-pointer"
    >
      <span className="center notextselect">{keyValue}</span>
    </div>
  );
}

export default Key;
