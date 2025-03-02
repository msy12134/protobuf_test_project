import os
import re

def find_files(root_path,prefix):
    for root, _, files in os.walk(root_path):
        for basename in files:
            if basename.endswith('.java'):
                filename = os.path.join(root, basename)
                modify_file(filename,prefix)


def modify_file(filename,prefix):
    regex = r'^(package\s+)([a-zA-Z_][a-zA-Z0-9_]*(?:\.[a-zA-Z_][a-zA-Z0-9_]*)*)(\s*;)'
    # 构造替换字符串，其中 \1 是 "package " 部分，
    # prefix 为传入的前缀，\2 是原来的包名，\3 是分号及其前可能的空白字符
    replacement = r'\1' + prefix + r'.\2\3'
    with open(filename,'r') as file:
        lines=file.readlines()
    new_lines = [ re.sub(regex,replacement,line) for line in lines]
    with open(filename,'w') as file:
        file.writelines(new_lines)

if __name__ == '__main__':
    find_files('./test_tool copy 3','wwww.abc.com.didi')