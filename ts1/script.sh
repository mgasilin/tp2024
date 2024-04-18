#!/bin/bash
start_directory="$1"
end_directory="$2"
files=( $(find "$start_directory" -type f) )
for file in "${files[@]}"; do
	fl="true"
	declare -i c=0

	name="${file##*/}"
	temp_name="$name"
	dir=$(dirname "$file")
	extention="${name##*.}"

	while [[ -f "$end_directory/$temp_name" || -f "$dir/$temp_name" ]]; do
	if [ "$name" != "$temp_name" ] || [ -f "$end_directory/$temp_name" ];
	then
		c="$c"+1
		fl="false"
		temp_name="${name%.*}($c).$extention"
	else
		fl="true"
		break
	fi
	done
	if [[ "$fl" == "false" ]];
	then
		mv "$file" "$dir""/$temp_name"
		cp "$dir""/$temp_name" "$end_directory"
		mv "$dir""/$temp_name" "$file"
	else
		cp "$dir""/$temp_name" "$end_directory"
	fi
done
