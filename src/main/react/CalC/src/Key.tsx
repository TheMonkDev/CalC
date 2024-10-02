interface KeyProps {
  keyValue: string;
}

function Key({ keyValue }: KeyProps) {
  return (
    <div className="relative h-full w-full cursor-pointer">
      <span className="center notextselect">{keyValue}</span>
    </div>
  );
}

export default Key;
