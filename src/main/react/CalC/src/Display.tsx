interface DisplayProps {
  displayText: string;
  isLoading: boolean;
}

// eslint-disable-next-line @typescript-eslint/no-unused-vars
function Display({ displayText, isLoading }: DisplayProps) {
  return (
    <div className="w-[97%] mx-auto my-2 h-[150px] bg-blue-300 border-[1px] border-solid border-black">
      {displayText}
    </div>
  );
}

export default Display;
